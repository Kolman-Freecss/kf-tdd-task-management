package org.kolmanfreecss.kftddtaskmanagement.application.mappers

import org.kolmanfreecss.kftddtaskmanagement.domain.dto.TaskDto
import org.kolmanfreecss.kftddtaskmanagement.domain.model.Task
import org.springframework.stereotype.Component

/**
 * TaskConverter
 * 
 * @version 1.0
 * @author Kolman-Freecss
 */
@Component
class TaskConverter {
    
    final ProjectConverter projectConverter
    
    TaskConverter(final ProjectConverter projectConverter) {
        this.projectConverter = projectConverter
    }
    
    /**
     * Convert Task to TaskDto
     * 
     * @param task
     * @return TaskDto
     */
    TaskDto toDto(Task task) {
        return new TaskDto(
            id: task.id,
            title: task.title,
            description: task.description,
            status: task.status,
            dueDate: task.dueDate,
            projectDto: projectConverter.toDto(task.project)
        )
    }
    
    /**
     * Convert TaskDto to Task
     * 
     * @param taskDto
     * @return Task
     */
    Task toEntity(TaskDto taskDto) {
        return new Task(
            title: taskDto.title,
            description: taskDto.description,
            status: taskDto.status,
            dueDate: taskDto.dueDate,
            project: projectConverter.toEntity(taskDto.projectDto)
        )
    }
    
}
