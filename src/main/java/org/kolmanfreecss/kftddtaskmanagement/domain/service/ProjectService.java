package org.kolmanfreecss.kftddtaskmanagement.domain.service;

import lombok.NoArgsConstructor;
import org.kolmanfreecss.kftddtaskmanagement.domain.dto.ProjectDto;
import org.springframework.stereotype.Service;

/**
 * Service class for a project.
 * 
 * @author Kolman-Freecss
 * @version 1.0
 */
@NoArgsConstructor
@Service
public class ProjectService {
    
    public ProjectDto createProject(final ProjectDto projectDto) {
        return projectDto;
    }
    
}
