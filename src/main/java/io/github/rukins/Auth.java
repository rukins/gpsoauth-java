package io.github.rukins;

import io.github.rukins.client.AuthClient;
import io.github.rukins.model.AccessToken;
import io.github.rukins.model.AccessTokenRequestParams;
import io.github.rukins.model.MasterToken;
import io.github.rukins.model.MasterTokenRequestParams;
import io.github.rukins.utils.Utils;

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
