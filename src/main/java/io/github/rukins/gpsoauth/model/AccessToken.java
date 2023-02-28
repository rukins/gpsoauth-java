package io.github.rukins.gpsoauth.model;

import com.google.gson.annotations.SerializedName;

public class AccessToken {
    private String issueAdvice;

    @SerializedName("Expiry")
    private String expiry;

    @SerializedName("ExpiresInDurationSec")
    private Integer expiresInDurationSec;

    private Integer storeConsentRemotely;

    private Integer isTokenSnowballed;

    private String grantedScopes;

    @SerializedName("Auth")
    private String accessToken;

    public String getIssueAdvice() {
        return issueAdvice;
    }

    public void setIssueAdvice(String issueAdvice) {
        this.issueAdvice = issueAdvice;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public Integer getExpiresInDurationSec() {
        return expiresInDurationSec;
    }

    public void setExpiresInDurationSec(Integer expiresInDurationSec) {
        this.expiresInDurationSec = expiresInDurationSec;
    }

    public Integer getStoreConsentRemotely() {
        return storeConsentRemotely;
    }

    public void setStoreConsentRemotely(Integer storeConsentRemotely) {
        this.storeConsentRemotely = storeConsentRemotely;
    }

    public Integer getIsTokenSnowballed() {
        return isTokenSnowballed;
    }

    public void setIsTokenSnowballed(Integer isTokenSnowballed) {
        this.isTokenSnowballed = isTokenSnowballed;
    }

    public String getGrantedScopes() {
        return grantedScopes;
    }

    public void setGrantedScopes(String grantedScopes) {
        this.grantedScopes = grantedScopes;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "issueAdvice='" + issueAdvice + '\'' +
                ", expiry='" + expiry + '\'' +
                ", expiresInDurationSec=" + expiresInDurationSec +
                ", storeConsentRemotely=" + storeConsentRemotely +
                ", isTokenSnowballed=" + isTokenSnowballed +
                ", grantedScopes='" + grantedScopes + '\'' +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
