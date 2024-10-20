package org.kolmanfreecss.kftddtaskmanagement.application.services;

import org.kolmanfreecss.kftddtaskmanagement.application.mappers.ProjectConverter;
import org.kolmanfreecss.kftddtaskmanagement.application.ports.ProjectRepositoryPort;
import org.kolmanfreecss.kftddtaskmanagement.domain.dto.ProjectDto;
import org.kolmanfreecss.kftddtaskmanagement.domain.model.Project;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
    
    private final ProjectConverter projectConverter;
    
    public ProjectService(@Qualifier("projectJDBCRepository") final ProjectRepositoryPort projectRepositoryPort,
                          final ProjectConverter projectConverter) {
        this.projectRepositoryPort = projectRepositoryPort;
        this.projectConverter = projectConverter;
    }

    public ProjectDto createProject(final ProjectDto projectDto) {
        Project entity = projectConverter.toEntity(projectDto);
        entity = projectRepositoryPort.createProject(entity);
        return projectConverter.toDto(entity);
    }

}
