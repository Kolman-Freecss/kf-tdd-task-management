package org.kolmanfreecss.kftddtaskmanagement.domain.dto

import groovy.transform.Immutable

/**
 * Groovy class for TaskDto (Groovy Just for fun)
 * 
 * @version 1.0
 * @author Kolman-Freecss
 */
@Immutable // Immutable annotation is used to make the class immutable (all fields are final and no setters are generated) like record in Java
class TaskDto {
    
    long id;
    
    String title;
    
    String description;
    
    String status;
    
    Date dueDate;

    ProjectDto projectDto;
    
}
