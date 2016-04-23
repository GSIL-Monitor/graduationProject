package com.beans;

/**
 * Created by wuhao on 16/4/21.
 */
public class Report {
    private long id;
    private String topic_id;
    private String beginReport;
    private String midReport;

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getMidReport() {
        return midReport;
    }

    public void setMidReport(String midReport) {
        this.midReport = midReport;
    }

    public String getBeginReport() {
        return beginReport;
    }

    public void setBeginReport(String beginReport) {
        this.beginReport = beginReport;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", topic_id='" + topic_id + '\'' +
                ", beginReport='" + beginReport + '\'' +
                ", midReport='" + midReport + '\'' +
                '}';
    }
}
