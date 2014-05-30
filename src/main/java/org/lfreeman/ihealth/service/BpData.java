package org.lfreeman.ihealth.service;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BpData {
    @JsonProperty("BPL")
    int bpl;
    @JsonProperty("DataID")
    String dataId;
    @JsonProperty("HP")
    int hp;
    @JsonProperty("HR")
    int hr;
    @JsonProperty("IsArr")
    int isArr;
    @JsonProperty("LP")
    int lp;
    @JsonProperty("LastChangeTime")
    int LastChangeTime;
    @JsonProperty("Lat")
    int lat;
    @JsonProperty("Lon")
    int lon;
    @JsonProperty("MDate")
    DateTime mDate;
    @JsonProperty("Note")
    String note;

    DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
    
    public int getBpl() {
        return bpl;
    }

    public void setBpl(int bpl) {
        this.bpl = bpl;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public int getIsArr() {
        return isArr;
    }

    public void setIsArr(int isArr) {
        this.isArr = isArr;
    }

    public int getLp() {
        return lp;
    }

    public void setLp(int lp) {
        this.lp = lp;
    }

    public int getLastChangeTime() {
        return LastChangeTime;
    }

    public void setLastChangeTime(int lastChangeTime) {
        LastChangeTime = lastChangeTime;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public String getmDate() {
        return formatter.print(mDate);
    }

    public void setmDate(int mDate) {
        this.mDate = new DateTime(mDate*1000L, DateTimeZone.UTC);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
