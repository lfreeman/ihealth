package org.lfreeman.ihealth.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessToken {

    @JsonProperty("APIName")
    private String apiName;
    @JsonProperty("AccessToken")
    private String accessToken;
    @JsonProperty("Expires")
    private String expires;
    @JsonProperty("RefreshToken")
    private String refreshToken;
    @JsonProperty("UserID")
    private String userId;
    @JsonProperty("client_para")
    private String clientPara;

    @JsonProperty("APIName")
    public String getApiName() {
        return apiName;
    }

    @JsonProperty("APIName")
    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    @JsonProperty("AccessToken")
    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty("AccessToken")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @JsonProperty("Expires")
    public String getExpires() {
        return expires;
    }

    @JsonProperty("Expires")
    public void setExpires(String expires) {
        this.expires = expires;
    }

    @JsonProperty("RefreshToken")
    public String getRefreshToken() {
        return refreshToken;
    }

    @JsonProperty("RefreshToken")
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @JsonProperty("UserID")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("UserID")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("client_para")
    public String getClientPara() {
        return clientPara;
    }

    @JsonProperty("client_para")
    public void setClientPara(String clientPara) {
        this.clientPara = clientPara;
    }

}
