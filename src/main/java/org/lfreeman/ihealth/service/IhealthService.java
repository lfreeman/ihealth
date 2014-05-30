package org.lfreeman.ihealth.service;

import org.joda.time.DateTime;

public interface IhealthService {
    String getAccessToken(String code);
    BloodPressure getBloodPresure(String userId, String accessToken, DateTime starTime, DateTime endTime, int pageIndex);
    String getUserAuthorizationUri();
    boolean isValidAccessToken();
    String getAccessToken();
    String getUserId();
}
