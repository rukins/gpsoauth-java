package io.github.rukins.gpsoauth.model;

import io.github.rukins.gpsoauth.annotation.Param;

import java.util.Locale;

public class MasterTokenRequestParams implements RequestParams {
    private MasterTokenRequestParams() {
    }

    private String lang;

    private String googlePlayServicesVersion;

    private Integer sdkVersion;

    private String deviceCountry;

    private String email;

    private String service;

    private Integer getAccountId;

    private Integer accessToken;

    private String callerPkg;

    private Integer addAccount;

    private String token;

    private String callerSig;

    public static Builder builder() {
        return new Builder();
    }

    public static Builder withDefaultValues() {
        Locale defaultLocale = Locale.US;

        return new Builder()
                .lang(defaultLocale.toString().replace("_", "-"))
                .googlePlayServicesVersion("19629032")
                .sdkVersion(28)
                .deviceCountry(defaultLocale.getCountry().toLowerCase())
                .service("ac2dm")
                .getAccountId(1)
                .accessToken(1)
                .callerPkg("com.google.android.gms")
                .addAccount(1)
                .callerSig("38918a453d07199354f8b19af05ec6562ced5788");
    }

    public static class Builder {
        private final MasterTokenRequestParams parameters = new MasterTokenRequestParams();

        private Builder() {}

        public Builder lang(String lang) {
            parameters.setLang(lang);

            return this;
        }

        public Builder googlePlayServicesVersion(String googlePlayServicesVersion) {
            parameters.setGooglePlayServicesVersion(googlePlayServicesVersion);

            return this;
        }

        public Builder sdkVersion(Integer sdkVersion) {
            parameters.setSdkVersion(sdkVersion);

            return this;
        }

        public Builder deviceCountry(String deviceCountry) {
            parameters.setDeviceCountry(deviceCountry);

            return this;
        }

        public Builder email(String email) {
            parameters.setEmail(email);

            return this;
        }

        public Builder service(String service) {
            parameters.setService(service);

            return this;
        }

        public Builder getAccountId(Integer getAccountId) {
            parameters.setGetAccountId(getAccountId);

            return this;
        }

        public Builder accessToken(Integer accessToken) {
            parameters.setAccessToken(accessToken);

            return this;
        }

        public Builder callerPkg(String callerPkg) {
            parameters.setCallerPkg(callerPkg);

            return this;
        }

        public Builder addAccount(Integer addAccount) {
            parameters.setAddAccount(addAccount);

            return this;
        }

        public Builder token(String token) {
            parameters.setToken(token);

            return this;
        }

        public Builder callerSig(String callerSig) {
            parameters.setCallerSig(callerSig);

            return this;
        }

        public MasterTokenRequestParams build() {
            return this.parameters;
        }
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Param("google_play_services_version")
    public String getGooglePlayServicesVersion() {
        return googlePlayServicesVersion;
    }

    public void setGooglePlayServicesVersion(String googlePlayServicesVersion) {
        this.googlePlayServicesVersion = googlePlayServicesVersion;
    }

    @Param("sdk_version")
    public Integer getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(Integer sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    @Param("device_country")
    public String getDeviceCountry() {
        return deviceCountry;
    }

    public void setDeviceCountry(String deviceCountry) {
        this.deviceCountry = deviceCountry;
    }

    @Param("Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Param("get_accountid")
    public Integer getGetAccountId() {
        return getAccountId;
    }

    public void setGetAccountId(Integer getAccountId) {
        this.getAccountId = getAccountId;
    }

    @Param("ACCESS_TOKEN")
    public Integer getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(Integer accessToken) {
        this.accessToken = accessToken;
    }

    public String getCallerPkg() {
        return callerPkg;
    }

    public void setCallerPkg(String callerPkg) {
        this.callerPkg = callerPkg;
    }

    @Param("add_account")
    public Integer getAddAccount() {
        return addAccount;
    }

    public void setAddAccount(Integer addAccount) {
        this.addAccount = addAccount;
    }

    @Param("Token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCallerSig() {
        return callerSig;
    }

    public void setCallerSig(String callerSig) {
        this.callerSig = callerSig;
    }
}
