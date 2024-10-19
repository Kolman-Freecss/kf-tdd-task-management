package org.kolmanfreecss.kftddtaskmanagement.infrastructure.adapters.out.hibernate;

import org.kolmanfreecss.kftddtaskmanagement.application.ports.ProjectRepositoryPort;
import org.kolmanfreecss.kftddtaskmanagement.domain.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ProjectHibernateRepository Hibernate Implementation
 * Used to define the methods that the ProjectHibernateRepository must implement.
 * 
 * @author Kolman-Freecss
 * @version 1.0
 */
@Repository("projectHibernateRepository")
public interface ProjectHibernateRepository extends JpaRepository<Project, Long>, ProjectRepositoryPort {
    
    @Override
    default Project createProject(final Project entity) {
        return save(entity);
    }
    
}
