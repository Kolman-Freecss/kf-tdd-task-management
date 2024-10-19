package org.kolmanfreecss.kftddtaskmanagement.domain.dto;

import groovy.transform.Immutable;

import java.util.Date;
import java.util.Set;

/**
 * DTO class for a project.
 * 
 * @author Kolman-Freecss
 * @see org.kolmanfreecss.kftddtaskmanagement.domain.model.Project
 * @version 1.0
 */
@Immutable // Compatability with Groovy TaskDto
public record ProjectDto(
        long id,
        String name,
        String description,
        Date startDate,
        Date endDate,
        Set<TaskDto> tasks
) {
}
