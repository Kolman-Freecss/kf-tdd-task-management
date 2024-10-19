package org.kolmanfreecss.kftddtaskmanagement.infrastructure.rest;

import org.kolmanfreecss.kftddtaskmanagement.domain.dto.ProjectDto;
import org.kolmanfreecss.kftddtaskmanagement.application.services.ProjectService;
import org.kolmanfreecss.kftddtaskmanagement.infrastructure.rest.common.BaseController;
import org.kolmanfreecss.kftddtaskmanagement.infrastructure.rest.model.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for a project.
 * Java implementation.
 * 
 * @author Kolman-Freecss
 * @see ProjectService
 * @version 1.0
 */
@RestController()
@RequestMapping("/api/v1/project")
public class ProjectController extends BaseController<ProjectDto> {
    
    private final ProjectService projectService;
    
    public ProjectController(final ProjectService projectService) {
        this.projectService = projectService;
    }
    
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ResponseWrapper<ProjectDto>> createProject(@RequestBody final ProjectDto projectDto) {
        return handleOperation(() -> this.projectService.createProject(projectDto),
                HttpStatus.CREATED,
                "Project created successfully");
    }
        
    
}
