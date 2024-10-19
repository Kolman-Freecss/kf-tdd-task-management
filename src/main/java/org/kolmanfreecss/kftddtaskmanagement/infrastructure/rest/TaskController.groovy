package org.kolmanfreecss.kftddtaskmanagement.infrastructure.rest

import lombok.AllArgsConstructor
import org.kolmanfreecss.kftddtaskmanagement.application.services.TasksService
import org.kolmanfreecss.kftddtaskmanagement.domain.dto.TaskDto
import org.kolmanfreecss.kftddtaskmanagement.infrastructure.rest.common.BaseController
import org.kolmanfreecss.kftddtaskmanagement.infrastructure.rest.model.ResponseWrapper
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Groovy class for TaskController (Groovy Just for fun) 
 * 
 * @version 1.0
 * @author Kolman-Freecss
 */
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/tasks")
class TaskController extends BaseController {
    
    private final TasksService tasksService;
    
    @GetMapping(produces = "application/json")
    ResponseEntity<ResponseWrapper<TaskDto>> getTasks() {
        return handleOperation(() -> tasksService.getAll());
    }
    
}
