package org.kolmanfreecss.kftddtaskmanagement.domain.model


import jakarta.persistence.*
import lombok.ToString

/**
 * Groovy class for Task (Groovy Just for fun)
 * Entity
 * 
 * @version 1.0
 * @author Kolman-Freecss
 */
@Entity
class Task {
    
    enum TaskStatus {
        PENDING,
        IN_PROGRESS,
        DONE
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    
    @Column(nullable = false)
    String title;
    
    String description;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TaskStatus status;
    
    @Column(nullable = false)
    Date dueDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    Project project;
    
    Task() {
    }
    
    Task(final String title, final String description, final TaskStatus status, final Date dueDate, final Project project) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.project = project;
    }
    
    @Override
    String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", dueDate=" + dueDate +
                ", project=" + project +
                '}';
    }
}
