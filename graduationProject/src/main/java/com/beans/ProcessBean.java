package com.beans;

/**
 * Created by wuhao on 16/4/26.
 */
public class ProcessBean {
    private String topic_id;
    private String studentName;
    private String studentNo;
    private String thesisName;
    private String topicBegin;
    private String topicMid;
    private String topicEnd;

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getThesisName() {
        return thesisName;
    }

    public void setThesisName(String thesisName) {
        this.thesisName = thesisName;
    }

    public String getTopicBegin() {
        return topicBegin;
    }

    public void setTopicBegin(String topicBegin) {
        this.topicBegin = topicBegin;
    }

    public String getTopicMid() {
        return topicMid;
    }

    public void setTopicMid(String topicMid) {
        this.topicMid = topicMid;
    }

    public String getTopicEnd() {
        return topicEnd;
    }

    public void setTopicEnd(String topicEnd) {
        this.topicEnd = topicEnd;
    }

    @Override
    public String toString() {
        return "ProcessBean{" +
                "topic_id='" + topic_id + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", thesisName='" + thesisName + '\'' +
                ", topicBegin='" + topicBegin + '\'' +
                ", topicMid='" + topicMid + '\'' +
                ", topicEnd='" + topicEnd + '\'' +
                '}';
    }
}
