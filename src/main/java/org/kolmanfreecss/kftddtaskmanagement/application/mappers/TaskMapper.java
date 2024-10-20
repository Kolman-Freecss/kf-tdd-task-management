//package org.kolmanfreecss.kftddtaskmanagement.application.mappers;
//
//import org.kolmanfreecss.kftddtaskmanagement.domain.dto.TaskDto;
//import org.kolmanfreecss.kftddtaskmanagement.domain.model.Task;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//
//
///**
// * Mapper class for a Task.
// * Java implementation.
// *
// * @author Kolman-Freecss
// * @version 1.0
// */
//@Mapper
//public interface TaskMapper {
//
//    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);
//
//    @Mapping(target = "projectDto", source = "project")
//    TaskDto toDto(final Task task);
//
//    @Mapping(target = "project", source = "projectDto")
//    Task toEntity(final TaskDto taskDto);
//
//}
