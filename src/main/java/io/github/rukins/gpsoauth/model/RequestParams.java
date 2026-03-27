package io.github.rukins.gpsoauth.model;

import java.util.Map;

public interface RequestParams {
    default Map<String, String> getParams() {
        return Map.of();
    }
}
