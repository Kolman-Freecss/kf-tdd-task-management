package org.kolmanfreecss.kftddtaskmanagement.infrastructure.adapters

import jakarta.transaction.Transactional
import org.kolmanfreecss.kftddtaskmanagement.application.services.TasksService
import org.kolmanfreecss.kftddtaskmanagement.domain.model.Project
import org.kolmanfreecss.kftddtaskmanagement.domain.model.Task
import org.kolmanfreecss.kftddtaskmanagement.infrastructure.adapters.out.hibernate.ProjectHibernateRepository
import org.kolmanfreecss.kftddtaskmanagement.infrastructure.adapters.out.hibernate.TaskHibernateRepository
import org.kolmanfreecss.kftddtaskmanagement.infrastructure.adapters.out.hibernate.TaskHibernateRepositoryPortImpl
import org.kolmanfreecss.kftddtaskmanagement.infrastructure.rest.TaskController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Groovy test class for TaskController
 * 
 * @version 1.0
 * @author Kolman-Freecss
 */
// JdbcTest is a specialized test slice that only loads the components needed to test JDBC code (more lightweight than @DataJdbcTest or @SpringBootTest)
//@JdbcTest // Used to test components that interact with the database
//@ContextConfiguration(classes = [TaskController, TasksService, TaskHibernateRepositoryPortImpl]) // Load the context with the controller
//@Transactional // To roll back database operations after each test
@SpringBootTest // Load the full application context
@ActiveProfiles("test") // Use the test profile
@AutoConfigureMockMvc // API testing
@Transactional // Roll back database operations after each test
class TaskControllerTest extends Specification {
    
    @Qualifier("taskHibernateRepositoryPortImpl")
    @Autowired
    TaskHibernateRepositoryPortImpl taskHibernateRepository;
    
    @Qualifier("projectHibernateRepository")
    @Autowired
    ProjectHibernateRepository projectHibernateRepository;
    
    @Autowired
    TaskController taskController;
    
    def setup() {
        final Project project = new Project("Project 1", "Description 1", new Date(), null);
        projectHibernateRepository.save(project);
        
        // Insert some tasks into the database for the test using H2-compatible syntax
        taskHibernateRepository.save(new Task("Task 1", "Description 1", Task.TaskStatus.PENDING, new Date(), project));
        taskHibernateRepository.save(new Task("Task 2", "Description 2", Task.TaskStatus.PENDING, new Date(), project));
        taskHibernateRepository.save(new Task("Task 3", "Description 3", Task.TaskStatus.PENDING, new Date(), project));
    }
    
    def "test getTasks should return all tasks"() {
        when: "The controller is called"
        def response = taskController.getTasks()
        
        then: "All tasks are returned"
        (response.getBody().dtoData as List<Task>).size() == 3
    }

}