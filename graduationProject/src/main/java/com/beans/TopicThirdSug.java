package com.beans;

/**
 * Created by wuhao on 16/4/19.
 */
public class TopicThirdSug {
    public long id;
    public String begin_sug;
    public String mid_sug;
    public String end_sug;
    public String topic_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBegin_sug() {
        return begin_sug;
    }

    public void setBegin_sug(String begin_sug) {
        this.begin_sug = begin_sug;
    }

    public String getMid_sug() {
        return mid_sug;
    }

    public void setMid_sug(String mid_sug) {
        this.mid_sug = mid_sug;
    }

    public String getEnd_sug() {
        return end_sug;
    }

    public void setEnd_sug(String end_sug) {
        this.end_sug = end_sug;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    @Override
    public String toString() {
        return "TopicThirdSug{" +
                "id=" + id +
                ", begin_sug='" + begin_sug + '\'' +
                ", mid_sug='" + mid_sug + '\'' +
                ", end_sug='" + end_sug + '\'' +
                ", topic_id='" + topic_id + '\'' +
                '}';
    }
}
