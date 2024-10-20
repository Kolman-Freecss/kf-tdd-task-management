package org.kolmanfreecss.kftddtaskmanagement.infrastructure.adapters.out;

import lombok.AllArgsConstructor;
import org.kolmanfreecss.kftddtaskmanagement.application.ports.ProjectRepositoryPort;
import org.kolmanfreecss.kftddtaskmanagement.domain.model.Project;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * ProjectJDBCRepository JDBC Implementation
 * Used to define the methods that the ProjectJDBCRepository must implement.
 * 
 * @author Kolman-Freecss
 * @version 1.0
 */
@AllArgsConstructor
@Repository("projectJDBCRepository")
public class ProjectJDBCRepository implements ProjectRepositoryPort {
    
    private final JdbcTemplate jdbcTemplate;
    
    public Project createProject(final Project entity) {
        final int id = jdbcTemplate.update("INSERT INTO project (name, description, start_date, end_date) VALUES (?, ?, ?, ?)",
                entity.getName(), entity.getDescription(), entity.getStartDate(), entity.getEndDate());
        entity.setId(id);
        return entity;
    }
    
}
