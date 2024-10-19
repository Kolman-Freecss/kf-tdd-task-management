package org.kolmanfreecss.kftddtaskmanagement.domain.dto;

import java.util.Date;

/**
 * DTO class for a project.
 * 
 * @author Kolman-Freecss
 * @see org.kolmanfreecss.kftddtaskmanagement.domain.model.Project
 * @version 1.0
 */
public record ProjectDto(
        long id,
        String name,
        String description,
        Date startDate,
        Date endDate
) {
}
