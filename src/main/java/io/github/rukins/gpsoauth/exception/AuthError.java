package io.github.rukins.gpsoauth.exception;

import io.github.rukins.gpsoauth.model.AuthErrorObject;

public class AuthError extends Exception {
    private final AuthErrorObject authErrorObject;

    public AuthError(AuthErrorObject authErrorObject) {
        super(authErrorObject.toString());

        this.authErrorObject = authErrorObject;
    }

    public AuthErrorObject getErrorObject() {
        return authErrorObject;
    }
}
