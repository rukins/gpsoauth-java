package io.github.rukins.gpsoauth.model;

import com.google.gson.annotations.SerializedName;

public class ErrorObject {
    @SerializedName("Error")
    private String cause;

    private Integer statusCode;

    public ErrorObject(String cause, Integer statusCode) {
        this.cause = cause;
        this.statusCode = statusCode;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "ErrorObject{" +
                "cause='" + cause + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}
