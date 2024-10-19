package org.kolmanfreecss.kftddtaskmanagement.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import lombok.NoArgsConstructor

/**
 * Groovy class for Task (Groovy Just for fun)
 * Entity
 * 
 * @version 1.0
 * @author Kolman-Freecss
 */
@NoArgsConstructor
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
    
}
