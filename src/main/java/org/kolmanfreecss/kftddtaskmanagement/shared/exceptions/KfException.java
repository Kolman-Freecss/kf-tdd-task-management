package org.kolmanfreecss.kftddtaskmanagement.shared.exceptions;

/**
 * KfException class.
 * Used to define the methods that the KfException must implement.
 * 
 * @author Kolman-Freecss
 * @version 1.0
 */
public class KfException extends RuntimeException {
    
    public KfException(final String message) {
        super(message);
    }
    
}
