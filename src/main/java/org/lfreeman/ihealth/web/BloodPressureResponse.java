package org.lfreeman.ihealth.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.lfreeman.ihealth.service.BloodPressure;
import org.lfreeman.ihealth.service.BpData;

public class BloodPressureResponse {
    private int draw;
    private int recordsTotal = 0;
    private int recordsFiltered = 0;
    private List<BpData> data;
    private String startTime;
    private String endTime;

    public BloodPressureResponse(Map<String, String> params, BloodPressure bp) {
        this.draw = NumberUtils.toInt(params.get("draw"), 0);

        this.data = bp.getBpDataList();
        if (data == null) {
            this.data = new ArrayList<BpData>();
        } else {
            this.recordsTotal = bp.getRecordCount();
        }

    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<BpData> getData() {
        return data;
    }

    public void setData(List<BpData> data) {
        this.data = data;
    }

}
