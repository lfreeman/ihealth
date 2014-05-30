package org.lfreeman.ihealth.web;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.lfreeman.ihealth.service.BloodPressure;
import org.lfreeman.ihealth.service.IhealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IhealthController {

    @Autowired
    private IhealthService ihealthService;

    @RequestMapping(value = "/bp", method = RequestMethod.GET)
    public String mainController(@RequestParam(value = "code", required = false) String code, Model model) {
        if (this.ihealthService.isValidAccessToken()) {
            return "bp";
        } else {
            if (code != null) {
                this.ihealthService.getAccessToken(code);
                return "bp";
            } else {
                return "redirect:" + this.ihealthService.getUserAuthorizationUri();
            }
        }
    }

    @RequestMapping(value = "/bp/data", method = RequestMethod.GET)
    public @ResponseBody BloodPressureResponse redirectController(@RequestParam Map<String, String> params, Model model) {
        String accessToken = this.ihealthService.getAccessToken();
        String userId = this.ihealthService.getUserId();

        DateTime startTime = toDateTime(params.get("submittime_from_id"));
        DateTime endTime = toDateTime(params.get("submittime_to_id"));
        BloodPressure bp = this.ihealthService.getBloodPresure(userId, accessToken, startTime, endTime, 1);
        return new BloodPressureResponse(params, bp);
    }

    public static DateTime toDateTime(String str) {
        final String pattern = "yyyy-MM-dd";
        if (!StringUtils.isNoneEmpty(str)) {
            return null;
        }

        try {
            return DateTimeFormat.forPattern(pattern).withZone(DateTimeZone.UTC).parseDateTime(str);
        } catch (IllegalArgumentException | UnsupportedOperationException ex) {
            return null;
        }
    }

}
