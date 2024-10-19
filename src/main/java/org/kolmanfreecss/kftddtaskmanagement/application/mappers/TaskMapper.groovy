package org.kolmanfreecss.kftddtaskmanagement.application.mappers

import org.kolmanfreecss.kftddtaskmanagement.domain.dto.TaskDto
import org.kolmanfreecss.kftddtaskmanagement.domain.model.Task
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

/**
 * Groovy class for TaskMapper (Groovy Just for fun)
 * 
 * @version 1.0
 * @author Kolman-Freecss
 */
@Mapper
interface TaskMapper {
    
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDto toDto(final Task task);
    
    Task toEntity(final TaskDto taskDto);
    
}
