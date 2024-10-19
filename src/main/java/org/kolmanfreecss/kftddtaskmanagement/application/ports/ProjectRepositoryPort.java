package org.kolmanfreecss.kftddtaskmanagement.application.ports;

import org.kolmanfreecss.kftddtaskmanagement.domain.dto.ProjectDto;
import org.kolmanfreecss.kftddtaskmanagement.domain.model.Project;

/**
 * ProjectPort
 * Used to define the methods that the ProjectService must implement.
 * 
 * @author Kolman-Freecss
 * @version 1.0
 */
public interface ProjectRepositoryPort {
    
    Project createProject(final ProjectDto projectDto);
    
}
