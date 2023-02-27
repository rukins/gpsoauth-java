package io.github.rukins.utils;

import com.google.gson.Gson;
import io.github.rukins.annotation.Param;
import io.github.rukins.model.RequestParams;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {
    private static final Gson gson = new Gson();

    public static <T> T getObjectFromString(String string, Class<T> objectClass) {
        return gson.fromJson(
                gson.toJsonTree(getMapFromString(string)),
                objectClass
        );
    }

    public static String getParamsStringFromObject(RequestParams params) {
        Map<String, String> paramsMap = new HashMap<>();

        for (Field field : params.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            Param paramAnnotation = field.getAnnotation(Param.class);
            String name = paramAnnotation != null ? paramAnnotation.value() : field.getName();

            Object value;
            try {
                value = field.get(params);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            paramsMap.put(name, value != null ? value.toString() : null);
        }

        return "?" + paramsMap.entrySet().stream()
                .map(p ->  p.getKey() + "=" + p.getValue())
                .collect(Collectors.joining("&"))
                .replaceAll(" ", "%20");
    }

    private static Map<String, String> getMapFromString(String str) {
        return str
                .lines()
                .map(s -> s.split("="))
                .collect(Collectors.toMap(a -> a[0], a -> a[1]));
    }
}
