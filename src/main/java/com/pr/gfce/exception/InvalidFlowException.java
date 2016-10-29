package com.pr.gfce.exception;

/**
 * @author Oscar Blancarte
 */
public class InvalidFlowException extends Exception {

    public InvalidFlowException(String message) {
        super(message);
    }

    public InvalidFlowException(String message, Throwable cause) {
        super(message, cause);
    }
}
