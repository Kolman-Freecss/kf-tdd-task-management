package org.kolmanfreecss.kftddtaskmanagement.application.mappers;

import org.kolmanfreecss.kftddtaskmanagement.domain.dto.ProjectDto;
import org.kolmanfreecss.kftddtaskmanagement.domain.model.Project;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Project Converter
 * Converts a Project entity to a ProjectDTO and vice versa
 * 
 * @author Kolman-Freecss
 * @version 1.0
 */
@Component
public class ProjectConverter {
    
    private final TaskConverter taskConverter;
    
    public ProjectConverter(final @Lazy TaskConverter taskConverter) {
        this.taskConverter = taskConverter;
    }
    
    /**
     * Converts a Project entity to a ProjectDTO
     * 
     * @param project: Project
     * @return ProjectDTO
     */
    public ProjectDto toDto(final Project project) {
        return new ProjectDto(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate(),
                project.getTasks().stream()
                        .map(taskConverter::toDto)
                        .collect(Collectors.toSet())
        );
    }
    
    /**
     * Converts a ProjectDTO to a Project entity
     * 
     * @param projectDTO: ProjectDTO
     * @return Project
     */
    public Project toEntity(final ProjectDto projectDTO) {
        return new Project(
                projectDTO.id(),
                projectDTO.name(),
                projectDTO.description(),
                projectDTO.startDate(),
                projectDTO.endDate(),
                projectDTO.tasks().stream()
                        .map(taskConverter::toEntity)
                        .collect(Collectors.toSet())
        );
    }
    
}
