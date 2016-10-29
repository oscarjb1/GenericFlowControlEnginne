package com.pr.gfce.exception;

/**
 * @author Oscar Blancarte
 */
public class ValidateException extends Exception {

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }
}
