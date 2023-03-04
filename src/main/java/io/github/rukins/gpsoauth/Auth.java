package io.github.rukins.gpsoauth;

import io.github.rukins.gpsoauth.client.AuthClient;
import io.github.rukins.gpsoauth.exception.AuthError;
import io.github.rukins.gpsoauth.model.*;
import io.github.rukins.gpsoauth.utils.Utils;

import java.net.http.HttpResponse;

public class Auth {
    private final AuthClient authClient = new AuthClient();

    public MasterToken getMasterToken(MasterTokenRequestParams params) throws AuthError {
        HttpResponse<String> response = authClient.post(params);

        checkIfError(response);

        return Utils.getObjectFromString(response.body(), MasterToken.class);
    }

    public AccessToken getAccessToken(AccessTokenRequestParams params) throws AuthError {
        HttpResponse<String> response = authClient.post(params);

        checkIfError(response);

        return Utils.getObjectFromString(response.body(), AccessToken.class);
    }

    private void checkIfError(HttpResponse<String> response) throws AuthError {
        if (response.statusCode() != 200) {
            AuthErrorObject authErrorObject = Utils.getObjectFromString(response.body(), AuthErrorObject.class);
            authErrorObject.setStatusCode(response.statusCode());

            throw new AuthError(authErrorObject);
        }
    }
}
