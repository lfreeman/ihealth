package org.lfreeman.ihealth.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BloodPressure {
    @JsonProperty("BPDataList")
    private List<BpData> bpDataList;

    @JsonProperty("NextPageUrl")
    private String nextPageUrl;

    @JsonProperty("CurrentRecordCount")
    private int currentRecordCount;

    @JsonProperty("PageLength")
    private int pageLength;

    @JsonProperty("PageNumber")
    private int pageNumber;

    @JsonProperty("PrevPageUrl")
    private String prevPageUrl;

    @JsonProperty("RecordCount")
    private int recordCount;

    @JsonProperty("BPUnit")
    private int bpUnit;

    public List<BpData> getBpDataList() {
        return bpDataList;
    }

    public void setBpDataList(List<BpData> bpDataList) {
        this.bpDataList = bpDataList;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public int getCurrentRecordCount() {
        return currentRecordCount;
    }

    public void setCurrentRecordCount(int currentRecordCount) {
        this.currentRecordCount = currentRecordCount;
    }

    public int getPageLength() {
        return pageLength;
    }

    public void setPageLength(int pageLength) {
        this.pageLength = pageLength;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPrevPageUrl() {
        return prevPageUrl;
    }

    public void setPrevPageUrl(String prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getBpUnit() {
        return bpUnit;
    }

    public void setBpUnit(int bpUnit) {
        this.bpUnit = bpUnit;
    }

}
