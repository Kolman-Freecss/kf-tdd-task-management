package org.kolmanfreecss.kftddtaskmanagement.infrastructure.rest


import org.kolmanfreecss.kftddtaskmanagement.application.services.TasksService
import org.kolmanfreecss.kftddtaskmanagement.domain.dto.TaskDto
import org.kolmanfreecss.kftddtaskmanagement.infrastructure.rest.common.BaseController
import org.kolmanfreecss.kftddtaskmanagement.infrastructure.rest.model.ResponseWrapper
import org.springframework.http.HttpStatus
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
//@TupleConstructor // Instead of @AllArgsConstructor from Lombok. Because Groovy is fun! x)
@RestController
@RequestMapping("/api/v1/tasks")
class TaskController extends BaseController {

    private final TasksService tasksService;

    TaskController(final TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping(produces = "application/json")
    ResponseEntity<ResponseWrapper<TaskDto>> getTasks() {
        return handleOperation(() -> tasksService.getAll(),
                HttpStatus.OK,
                "Tasks retrieved successfully") as ResponseEntity<ResponseWrapper<TaskDto>>;
    }

}
