package org.lfreeman.ihealth.service;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class IhealthApi {

    @Value("${userAuthorizationUri}")
    private String userAuthorizationUri;

    @Value("${bpApiUrl}")
    private String bpApiUrl;

    private static final Logger logger = LoggerFactory.getLogger(IhealthApi.class);

    private final RestTemplate restTemplate;

    @Autowired
    public IhealthApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AccessToken getAccessToken(String client_id, String client_secret, String redirect_uri, String code) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(userAuthorizationUri);
        builder.queryParam("client_id", client_id);
        builder.queryParam("client_secret", client_secret);
        builder.queryParam("grant_type", "authorization_code");
        builder.queryParam("redirect_uri", redirect_uri);
        builder.queryParam("code", code);

        AccessToken accessToken = restTemplate.getForObject(builder.build().toString(), AccessToken.class);
        return accessToken;
    }

    public BloodPressure getBp(String userId, String clientId, String clientSecret, String redirectUri,
            String accessToken, DateTime starTime, DateTime endTime, int pageIndex, String sc, String sv) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(bpApiUrl);
        builder.pathSegment(userId);
        builder.pathSegment("bp.json");
        builder.queryParam("client_id", clientId);
        builder.queryParam("client_secret", clientSecret);
        builder.queryParam("grant_type", "authorization_code");
        builder.queryParam("redirect_uri", redirectUri);
        builder.queryParam("access_token", accessToken);
        if (starTime != null) {
            builder.queryParam("start_time", Long.toString(starTime.getMillis() / 1000));
        } else {
            builder.queryParam("start_time",
                    Long.toString((new DateTime(DateTimeZone.UTC)).minusYears(5).getMillis() / 1000));
        }
        if (endTime != null) {
            builder.queryParam("end_time", Long.toString(endTime.getMillis() / 1000));
        }
        builder.queryParam("page_index", pageIndex);
        builder.queryParam("sc", sc);
        builder.queryParam("sv", sv);

        BloodPressure bloodPressure = restTemplate.getForObject(builder.build().toString(), BloodPressure.class);
        return bloodPressure;

    }

}
