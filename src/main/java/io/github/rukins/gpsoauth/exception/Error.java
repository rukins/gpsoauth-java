package io.github.rukins.gpsoauth.exception;

import io.github.rukins.gpsoauth.model.ErrorObject;

public class Error extends Exception {
    private final ErrorObject errorObject;

    public Error(ErrorObject errorObject) {
        super(errorObject.toString());

        this.errorObject = errorObject;
    }

    public ErrorObject getErrorObject() {
        return errorObject;
    }
}
