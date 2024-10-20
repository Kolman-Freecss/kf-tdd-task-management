package org.kolmanfreecss.kftddtaskmanagement.application.services

import org.kolmanfreecss.kftddtaskmanagement.application.mappers.TaskConverter
import org.kolmanfreecss.kftddtaskmanagement.application.ports.TaskRepositoryPort
import org.kolmanfreecss.kftddtaskmanagement.domain.dto.TaskDto
import org.kolmanfreecss.kftddtaskmanagement.shared.exceptions.KfException
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
    
    final TaskConverter taskConverter;
    
    TasksService(@Qualifier("taskHibernateRepositoryPortImpl") final TaskRepositoryPort taskRepositoryPort,
                 final TaskConverter taskConverter) {
        this.taskRepositoryPort = taskRepositoryPort;
        this.taskConverter = taskConverter;
    }
    
    /**
     * Get all tasks
     * 
     * @return Set<TaskDto>
     */
    Set<TaskDto> getAll() throws KfException {
        try {
            final Set<TaskDto> taskList = taskRepositoryPort.getAll().stream()
                .map { taskConverter.toDto(it) }
                .collect(Collectors.toSet());
            return taskList;
        } catch (Exception e) {
            throw new KfException("Error getting tasks", e);
        }
    } 
    
}
