package org.lfreeman.ihealth.service;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class IhealthServiceImpl implements IhealthService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AccessTokenSession accessTokenSession;

    @Autowired
    private IhealthApi ihealthApi;

    @Value("${clientId}")
    private String clientId;

    @Value("${clientSecret}")
    private String clientSecret;

    @Value("${bpUrl}")
    private String redirectUri;

    @Value("${sc}")
    private String sc;

    @Value("${sv}")
    private String sv;

    @Value("${userAuthorizationUri}")
    private String userAuthorizationUri;

    @Override
    public String getAccessToken(String code) {
        AccessToken accessToken = ihealthApi.getAccessToken(clientId, clientSecret, redirectUri, code);
        String token = accessToken.getAccessToken();
        accessTokenSession.setAccessToken(token);
        accessTokenSession.setUserId(accessToken.getUserId());
        return token;
    }

    @Override
    public BloodPressure getBloodPresure(String userId, String accessToken, DateTime starTime, DateTime endTime, int pageIndex) {

        BloodPressure bloodPressure = ihealthApi.getBp(userId, clientId, clientSecret, redirectUri, accessToken, starTime,
                endTime, pageIndex, sc, sv);
        return bloodPressure;
    }

    @Override
    public String getUserAuthorizationUri() {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(userAuthorizationUri);
        builder.queryParam("client_id", clientId);
        builder.queryParam("response_type", "code");
        builder.queryParam("redirect_uri", redirectUri);

        builder.queryParam("APIName", "OpenApiBP");
        return builder.build().toString();
    }

    @Override
    public boolean isValidAccessToken() {
        if (accessTokenSession.getAccessToken() != null) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String getAccessToken() {
        return accessTokenSession.getAccessToken();
    }

    @Override
    public String getUserId() {
        return accessTokenSession.getUserId();
    }

}
