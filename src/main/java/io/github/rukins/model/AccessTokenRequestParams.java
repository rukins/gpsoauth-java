package io.github.rukins.model;

import io.github.rukins.annotation.Param;

import java.util.Locale;

public class AccessTokenRequestParams implements RequestParams {
    private AccessTokenRequestParams() {
    }

    private String accountType;

    @Param("Email")
    private String email;

    @Param("has_permission")
    private Integer hasPermission;

    @Param("EncryptedPasswd")
    private String masterToken;

    @Param("service")
    private String scopes;

    private String source;

    private String androidId;

    private String app;

    @Param("client_sig")
    private String clientSig;

    @Param("device_country")
    private String deviceCountry;

    private String operatorCountry;

    private String lang;

    @Param("sdk_version")
    private Integer sdkVersion;

    public static Builder builder() {
        return new Builder();
    }

    public static Builder withDefaultValues() {
        Locale defaultLocale = Locale.US;

        return new Builder()
                .accountType("HOSTED_OR_GOOGLE")
                .email("")
                .hasPermission(1)
                .source("android")
                .androidId("")
                .clientSig("38918a453d07199354f8b19af05ec6562ced5788")
                .deviceCountry(defaultLocale.getCountry().toLowerCase())
                .operatorCountry(defaultLocale.getCountry().toLowerCase())
                .lang(defaultLocale.getLanguage())
                .sdkVersion(28);
    }

    public static class Builder {
        private final AccessTokenRequestParams parameters = new AccessTokenRequestParams();

        private Builder() {}

        public Builder accountType(String accountType) {
            parameters.setAccountType(accountType);

            return this;
        }

        public Builder email(String email) {
            parameters.setEmail(email);

            return this;
        }

        public Builder hasPermission(Integer hasPermission) {
            parameters.setHasPermission(hasPermission);

            return this;
        }

        public Builder masterToken(String masterToken) {
            parameters.setMasterToken(masterToken);

            return this;
        }

        public Builder scopes(String scopes) {
            parameters.setScopes(scopes);

            return this;
        }

        public Builder source(String source) {
            parameters.setSource(source);

            return this;
        }

        public Builder androidId(String androidId) {
            parameters.setAndroidId(androidId);

            return this;
        }

        public Builder app(String app) {
            parameters.setApp(app);

            return this;
        }

        public Builder clientSig(String clientSig) {
            parameters.setClientSig(clientSig);

            return this;
        }

        public Builder deviceCountry(String deviceCountry) {
            parameters.setDeviceCountry(deviceCountry);

            return this;
        }

        public Builder operatorCountry(String operatorCountry) {
            parameters.setOperatorCountry(operatorCountry);

            return this;
        }

        public Builder lang(String lang) {
            parameters.setLang(lang);

            return this;
        }

        public Builder sdkVersion(Integer sdkVersion) {
            parameters.setSdkVersion(sdkVersion);

            return this;
        }

        public AccessTokenRequestParams build() {
            return parameters;
        }
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getHasPermission() {
        return hasPermission;
    }

    public void setHasPermission(Integer hasPermission) {
        this.hasPermission = hasPermission;
    }

    public String getMasterToken() {
        return masterToken;
    }

    public void setMasterToken(String masterToken) {
        this.masterToken = masterToken;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getClientSig() {
        return clientSig;
    }

    public void setClientSig(String clientSig) {
        this.clientSig = clientSig;
    }

    public String getDeviceCountry() {
        return deviceCountry;
    }

    public void setDeviceCountry(String deviceCountry) {
        this.deviceCountry = deviceCountry;
    }

    public String getOperatorCountry() {
        return operatorCountry;
    }

    public void setOperatorCountry(String operatorCountry) {
        this.operatorCountry = operatorCountry;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Integer getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(Integer sdkVersion) {
        this.sdkVersion = sdkVersion;
    }
}
