package io.github.rukins.model;

import com.google.gson.annotations.SerializedName;

public class MasterToken {

    @SerializedName("Token")
    private String masterToken;

    @SerializedName("Auth")
    private String auth;

    @SerializedName("SID")
    private String sid;

    @SerializedName("LSID")
    private String lsid;

    private String services;

    @SerializedName("Email")
    private String email;

    private String accountId;

    @SerializedName("GooglePlusUpdate")
    private String googlePlusUpdate;

    private String firstName;

    private String lastName;

    private Capabilities capabilitiesObject;

    private String capabilities;

    public static class Capabilities {
        private Integer canHaveUsername;
        private Integer canHavePassword;

        public Integer getCanHaveUsername() {
            return canHaveUsername;
        }

        public void setCanHaveUsername(Integer canHaveUsername) {
            this.canHaveUsername = canHaveUsername;
        }

        public Integer getCanHavePassword() {
            return canHavePassword;
        }

        public void setCanHavePassword(Integer canHavePassword) {
            this.canHavePassword = canHavePassword;
        }
    }

    public String getMasterToken() {
        return masterToken;
    }

    public void setMasterToken(String masterToken) {
        this.masterToken = masterToken;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getLsid() {
        return lsid;
    }

    public void setLsid(String lsid) {
        this.lsid = lsid;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getGooglePlusUpdate() {
        return googlePlusUpdate;
    }

    public void setGooglePlusUpdate(String googlePlusUpdate) {
        this.googlePlusUpdate = googlePlusUpdate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Capabilities getCapabilitiesObject() {
        return capabilitiesObject;
    }

    public void setCapabilitiesObject(Capabilities capabilitiesObject) {
        this.capabilitiesObject = capabilitiesObject;
    }

    public String getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(String capabilities) {
        this.capabilities = capabilities;
    }

    @Override
    public String toString() {
        return "MasterToken{" +
                "masterToken='" + masterToken + '\'' +
                ", auth='" + auth + '\'' +
                ", sid='" + sid + '\'' +
                ", lsid='" + lsid + '\'' +
                ", services='" + services + '\'' +
                ", email='" + email + '\'' +
                ", accountId='" + accountId + '\'' +
                ", googlePlusUpdate='" + googlePlusUpdate + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", capabilitiesObject=" + capabilitiesObject +
                ", capabilities='" + capabilities + '\'' +
                '}';
    }
}
