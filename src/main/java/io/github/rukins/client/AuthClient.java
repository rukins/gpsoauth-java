package io.github.rukins.client;

import io.github.rukins.model.RequestParams;
import io.github.rukins.utils.Utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class AuthClient {
    public static final String AUTH_URI = "https://android.clients.google.com/auth";

    private final HttpClient client = HttpClient.newHttpClient();

    public HttpResponse<String> post(RequestParams params) {
        return post(params, null, Map.of("Accept", "*/*"));
    }

    public HttpResponse<String> post(RequestParams params,
                                     String body,
                                     Map<String, String> headers) {
        HttpRequest request;
        try {
            request = HttpRequest.newBuilder()
                    .uri(
                            new URI(AUTH_URI + Utils.getParamsStringFromObject(params))
                    )
                    .headers(
                            headers.entrySet().stream()
                                    .map(h -> Arrays.asList(h.getKey(), h.getValue()))
                                    .flatMap(Collection::stream)
                                    .toArray(String[]::new)
                    )
                    .POST(
                            body != null
                                    ? HttpRequest.BodyPublishers.ofString(body)
                                    : HttpRequest.BodyPublishers.noBody()
                    )
                    .build();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
