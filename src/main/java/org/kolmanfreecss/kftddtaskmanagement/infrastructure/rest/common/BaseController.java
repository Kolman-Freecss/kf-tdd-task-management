package org.kolmanfreecss.kftddtaskmanagement.infrastructure.rest.common;

import org.kolmanfreecss.kftddtaskmanagement.infrastructure.rest.model.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

/**
 * Base controller class.
 * Java implementation.
 * 
 * @author Kolman-Freecss
 * @version 1.0
 */
public abstract class BaseController<T> {
    
    protected <T> ResponseEntity<ResponseWrapper<T>> handleOperation(final Supplier<T> supplier,
                                                                     final HttpStatus status,
                                                                     final String successMessage) {
        try {
            final T data = supplier.get();
            return ResponseEntity.status(status).body(new ResponseWrapper<>(successMessage, data));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseWrapper<>("Error performing operation", 
                    null));
        }
        
    }
    
}
