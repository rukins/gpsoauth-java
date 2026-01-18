package io.github.rukins.gpsoauth.client;

import io.github.rukins.gpsoauth.model.RequestParams;
import io.github.rukins.gpsoauth.utils.Utils;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

public class AuthClient {
    public static final String AUTH_URI = "https://android.clients.google.com/auth";

    private final OkHttpClient client = new OkHttpClient();

    public HttpResponse post(RequestParams params) {
        return post(params, null, Map.of("Accept", "*/*"));
    }

    public HttpResponse post(RequestParams params,
                             String body,
                             Map<String, String> headers) {
        String url = AUTH_URI + Utils.getParamsStringFromObject(params);
        
        Request.Builder requestBuilder = new Request.Builder()
                .url(url);
        
        // Add headers
        for (Map.Entry<String, String> header : headers.entrySet()) {
            requestBuilder.addHeader(header.getKey(), header.getValue());
        }
        
        // Add body
        RequestBody requestBody = body != null
                ? RequestBody.create(body, MediaType.parse("text/plain"))
                : RequestBody.create("", null);
        requestBuilder.post(requestBody);
        
        Request request = requestBuilder.build();
        
        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body() != null ? response.body().string() : "";
            return new HttpResponse(response.code(), responseBody);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Simple wrapper class to maintain API compatibility
     */
    public static class HttpResponse {
        private final int statusCode;
        private final String body;
        
        public HttpResponse(int statusCode, String body) {
            this.statusCode = statusCode;
            this.body = body;
        }
        
        public int statusCode() {
            return statusCode;
        }
        
        public String body() {
            return body;
        }
    }
}
