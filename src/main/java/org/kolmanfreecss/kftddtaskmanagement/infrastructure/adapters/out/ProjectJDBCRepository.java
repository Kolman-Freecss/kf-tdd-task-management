package org.kolmanfreecss.kftddtaskmanagement.infrastructure.adapters.out;

import org.kolmanfreecss.kftddtaskmanagement.application.ports.ProjectRepositoryPort;
import org.kolmanfreecss.kftddtaskmanagement.domain.dto.ProjectDto;
import org.kolmanfreecss.kftddtaskmanagement.domain.model.Project;
import org.springframework.stereotype.Component;

/**
 * ProjectJDBCRepository JDBC Implementation
 * Used to define the methods that the ProjectJDBCRepository must implement.
 * 
 * @author Kolman-Freecss
 * @version 1.0
 */
@Component("projectJDBCRepository")
public class ProjectJDBCRepository implements ProjectRepositoryPort {
    
    public Project createProject(final ProjectDto projectDto) {
        return new Project(projectDto.id(), projectDto.name(), projectDto.description(), projectDto.startDate(), projectDto.endDate());
    }
    
}
