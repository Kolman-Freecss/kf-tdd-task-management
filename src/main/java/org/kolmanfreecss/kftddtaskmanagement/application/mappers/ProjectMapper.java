package org.kolmanfreecss.kftddtaskmanagement.application.mappers;

import org.kolmanfreecss.kftddtaskmanagement.domain.dto.ProjectDto;
import org.kolmanfreecss.kftddtaskmanagement.domain.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper class for a project.
 * Java implementation.
 * 
 * @author Kolman-Freecss
 * @version 1.0
 */
@Mapper
public interface ProjectMapper {
    
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
    
    ProjectDto toDto(final Project project);
    
    Project toEntity(final ProjectDto projectDto);
    
}
