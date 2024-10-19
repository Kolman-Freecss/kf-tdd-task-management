package org.kolmanfreecss.kftddtaskmanagement.application.services;

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
    
    public ProjectService(@Qualifier("projectHibernateRepository") final ProjectRepositoryPort projectRepositoryPort) {
        this.projectRepositoryPort = projectRepositoryPort;
    }
    
    public ProjectDto createProject(final ProjectDto projectDto) {
        final Project entity = projectRepositoryPort.createProject(projectDto);
        return new ProjectDto(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getStartDate(),
                entity.getEndDate()
        );
    }
    
}
