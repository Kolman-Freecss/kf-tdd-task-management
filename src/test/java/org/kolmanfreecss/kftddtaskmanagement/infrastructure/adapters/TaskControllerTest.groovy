package org.kolmanfreecss.kftddtaskmanagement.infrastructure.adapters

import jakarta.transaction.Transactional
import org.kolmanfreecss.kftddtaskmanagement.domain.model.Task
import org.kolmanfreecss.kftddtaskmanagement.infrastructure.adapters.out.hibernate.TaskHibernateRepository
import org.kolmanfreecss.kftddtaskmanagement.infrastructure.rest.TaskController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Groovy test class for TaskController
 * 
 * @version 1.0
 * @author Kolman-Freecss
 */
// JdbcTest is a specialized test slice that only loads the components needed to test JDBC code (more lightweight than @DataJdbcTest or @SpringBootTest)
@JdbcTest // Used to test components that interact with the database
@ContextConfiguration(classes = [TaskController]) // Load the context with the controller
@Transactional // To roll back database operations after each test
class TaskControllerTest extends Specification {
    
    @Autowired
    TaskHibernateRepository taskHibernateRepository;
    
    @Autowired
    TaskController taskController;
    
    def setup() {
        // Insert some tasks into the database for the test using H2-compatible syntax
        taskHibernateRepository.save(new Task(title: "Task 1", description: "Description 1"));
        taskHibernateRepository.save(new Task(title: "Task 2", description: "Description 2"));
        taskHibernateRepository.save(new Task(title: "Task 3", description: "Description 3"));
    }
    
    def "test getTasks should return all tasks"() {
        when: "The controller is called"
        def response = taskController.getTasks()
        
        then: "All tasks are returned"
        response.getBody().data.size() == 3
    }

}