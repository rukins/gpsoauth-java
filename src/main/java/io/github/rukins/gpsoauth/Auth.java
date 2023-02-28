package io.github.rukins.gpsoauth;

import io.github.rukins.gpsoauth.client.AuthClient;
import io.github.rukins.gpsoauth.model.AccessToken;
import io.github.rukins.gpsoauth.model.MasterToken;
import io.github.rukins.gpsoauth.model.MasterTokenRequestParams;
import io.github.rukins.gpsoauth.utils.Utils;
import io.github.rukins.gpsoauth.model.AccessTokenRequestParams;

import java.net.http.HttpResponse;

public class Auth {
    private final AuthClient authClient = new AuthClient();

    public MasterToken getMasterToken(MasterTokenRequestParams params) {
        HttpResponse<String> response = authClient.post(params);

        return Utils.getObjectFromString(response.body(), MasterToken.class);
    }

    public AccessToken getAccessToken(AccessTokenRequestParams params) {
        HttpResponse<String> response = authClient.post(params);

        return Utils.getObjectFromString(response.body(), AccessToken.class);
    }
}
