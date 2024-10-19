package org.kolmanfreecss.kftddtaskmanagement.application.services

import org.kolmanfreecss.kftddtaskmanagement.application.mappers.TaskMapper
import org.kolmanfreecss.kftddtaskmanagement.application.ports.TaskRepositoryPort
import org.kolmanfreecss.kftddtaskmanagement.domain.dto.TaskDto
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

import java.util.stream.Collectors

/**
 * Groovy class for TasksService (Groovy Just for fun)
 * 
 * @version 1.0
 * @author Kolman-Freecss
 */
@Service
class TasksService {
    
    final TaskRepositoryPort taskRepositoryPort;
    
    TasksService(@Qualifier("taskHibernateRepository") final TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }
    
    /**
     * Get all tasks
     * 
     * @return Set<TaskDto>
     */
    Set<TaskDto> getAll() {
        final Set<TaskDto> taskList = taskRepositoryPort.getAll().stream()
            .map { TaskMapper.INSTANCE.toDto(it) }
            .collect(Collectors.toSet());
        return taskList;
    }
    
}
