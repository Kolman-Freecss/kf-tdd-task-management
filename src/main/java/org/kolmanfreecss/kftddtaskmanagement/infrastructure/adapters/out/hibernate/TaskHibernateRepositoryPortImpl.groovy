package org.kolmanfreecss.kftddtaskmanagement.infrastructure.adapters.out.hibernate

import org.kolmanfreecss.kftddtaskmanagement.application.ports.TaskRepositoryPort
import org.kolmanfreecss.kftddtaskmanagement.domain.model.Task
import org.springframework.stereotype.Repository

/**
 * TaskHibernateRepository
 * Groovy class for TaskHibernateRepository (Groovy Just for fun)
 *
 * @author Kolman-Freecss
 * @version 1.0
 */
@Repository("taskHibernateRepositoryPortImpl")
class TaskHibernateRepositoryPortImpl implements TaskRepositoryPort {

    private final TaskHibernateRepository taskHibernateRepository;

    TaskHibernateRepositoryPortImpl(TaskHibernateRepository taskHibernateRepository) {
        this.taskHibernateRepository = taskHibernateRepository;
    }

    @Override
    Set<Task> getAll() {
        return taskHibernateRepository.findAll().collect { it as Task }.toSet();
    }

}
