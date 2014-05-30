package org.lfreeman.ihealth.service;

import java.io.Serializable;

public class AccessTokenSession implements Serializable {

    private static final long serialVersionUID = -8157980498156521794L;
    private String accessToken;
    private String userId;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
