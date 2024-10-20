package org.kolmanfreecss.kftddtaskmanagement.application.ports

import org.kolmanfreecss.kftddtaskmanagement.domain.model.Task

/**
 * Port for TaskRepository
 * Groovy class for TaskRepositoryPort (Groovy Just for fun)
 * 
 * @version 1.0
 * @author Kolman-Freecss
 */
interface TaskRepositoryPort {
    
    Task save(final Task task);
    
    Set<Task> getAll();
    
}
