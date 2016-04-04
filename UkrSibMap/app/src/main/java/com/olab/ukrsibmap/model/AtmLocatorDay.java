package com.olab.ukrsibmap.model;

/**
 * Created by Oleg on 01/04/2016.
 */
public class AtmLocatorDay {
    private String day = "";
    private String end = "";
    private boolean isUkrain = true;
    private String start = "";
    private String time = "";

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public boolean isUkrain() {
        return isUkrain;
    }

    public void setIsUkrain(boolean isUkrain) {
        this.isUkrain = isUkrain;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
