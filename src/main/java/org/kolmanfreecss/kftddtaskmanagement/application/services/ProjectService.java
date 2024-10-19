package org.kolmanfreecss.kftddtaskmanagement.application.services;

import org.kolmanfreecss.kftddtaskmanagement.application.mappers.ProjectMapper;
import org.kolmanfreecss.kftddtaskmanagement.application.mappers.TaskMapper;
import org.kolmanfreecss.kftddtaskmanagement.application.ports.ProjectRepositoryPort;
import org.kolmanfreecss.kftddtaskmanagement.domain.dto.ProjectDto;
import org.kolmanfreecss.kftddtaskmanagement.domain.dto.TaskDto;
import org.kolmanfreecss.kftddtaskmanagement.domain.model.Project;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service class for a project.
 * 
 * @author Kolman-Freecss
 * @version 1.0
 */
// @AllArgsConstructor // Lombok annotation not inject @Qualifier annotation 
@Service
public class ProjectService {
    
    private final ProjectRepositoryPort projectRepositoryPort;
    
    public ProjectService(@Qualifier("projectJDBCRepository") final ProjectRepositoryPort projectRepositoryPort) {
        this.projectRepositoryPort = projectRepositoryPort;
    }
    
    public ProjectDto createProject(final ProjectDto projectDto) {
        Project entity = ProjectMapper.INSTANCE.toEntity(projectDto);
        entity = projectRepositoryPort.createProject(entity);
        final Set<TaskDto> tasks = entity.getTasks().stream()
                .map(TaskMapper.INSTANCE::toDto)
                .collect(Collectors.toSet());
        return new ProjectDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getStartDate(),
                entity.getEndDate(),
                tasks
        );
    }
    
}
