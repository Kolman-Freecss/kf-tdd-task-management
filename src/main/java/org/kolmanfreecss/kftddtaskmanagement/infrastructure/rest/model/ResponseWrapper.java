package org.kolmanfreecss.kftddtaskmanagement.infrastructure.rest.model;

/**
 * Wrapper class for a response.
 *
 * @author Kolman-Freecss
 * @version 1.0
 */
public record ResponseWrapper<T>(
        String message,
        T dtoData
) {
    public String getMessage() {
        return message;
    }

    public T getDtoData() {
        return dtoData;
    }
}
