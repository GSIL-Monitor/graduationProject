package com.beans;

/**
 * Created by wuhao on 16/4/19.
 */
public class TopicStatus {
    public long id;
    public String topicId;
    public int topicBegin;
    public int topicMid;
    public int topicFinal;
    public int beginScore;
    public int midScore;
    public int finalScore;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public int getTopicBegin() {
        return topicBegin;
    }

    public void setTopicBegin(int topicBegin) {
        this.topicBegin = topicBegin;
    }

    public int getTopicMid() {
        return topicMid;
    }

    public void setTopicMid(int topicMid) {
        this.topicMid = topicMid;
    }

    public int getTopicFinal() {
        return topicFinal;
    }

    public void setTopicFinal(int topicFinal) {
        this.topicFinal = topicFinal;
    }

    public int getBeginScore() {
        return beginScore;
    }

    public void setBeginScore(int beginScore) {
        this.beginScore = beginScore;
    }

    public int getMidScore() {
        return midScore;
    }

    public void setMidScore(int midScore) {
        this.midScore = midScore;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }


    @Override
    public String toString() {
        return "TopicStatus{" +
                "id=" + id +
                ", topicId=" + topicId +
                ", topicBegin=" + topicBegin +
                ", topicMid=" + topicMid +
                ", topicFinal=" + topicFinal +
                ", beginScore=" + beginScore +
                ", midScore=" + midScore +
                ", finalScore=" + finalScore +
                '}';
    }
}
