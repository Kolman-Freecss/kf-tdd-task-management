package org.kolmanfreecss.kftddtaskmanagement.infrastructure.adapters.out.hibernate

import org.kolmanfreecss.kftddtaskmanagement.application.ports.TaskRepositoryPort
import org.kolmanfreecss.kftddtaskmanagement.domain.model.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * TaskHibernateRepository
 * Groovy class for TaskHibernateRepository (Groovy Just for fun)
 *
 * @author Kolman-Freecss
 * @version 1.0
 */
@Repository
interface TaskHibernateRepository extends JpaRepository<Task, Long> {

}
