package com.beans;

import java.util.Date;

/**
 * Created by wuhao on 16/4/19.
 */
public class TopicCheckProcess {
    public long id;
    public Date topicCommitBegin;
    public Date topicCommitEnd;
    public Date choiceBegin;
    public Date choiceEnd;
    public Date topicBegin;
    public Date topicEnd;
    public Date topicMidBegin;
    public Date topicMidEnd;
    public Date topicFinalBegin;
    public Date topicFinalEnd;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getChoiceBegin() {
        return choiceBegin;
    }

    public void setChoiceBegin(Date choiceBegin) {
        this.choiceBegin = choiceBegin;
    }

    public Date getChoiceEnd() {
        return choiceEnd;
    }

    public void setChoiceEnd(Date choiceEnd) {
        this.choiceEnd = choiceEnd;
    }

    public Date getTopicBegin() {
        return topicBegin;
    }

    public void setTopicBegin(Date topicBegin) {
        this.topicBegin = topicBegin;
    }

    public Date getTopicEnd() {
        return topicEnd;
    }

    public void setTopicEnd(Date topicEnd) {
        this.topicEnd = topicEnd;
    }

    public Date getTopicMidBegin() {
        return topicMidBegin;
    }

    public void setTopicMidBegin(Date topicMidBegin) {
        this.topicMidBegin = topicMidBegin;
    }

    public Date getTopicMidEnd() {
        return topicMidEnd;
    }

    public void setTopicMidEnd(Date topicMidEnd) {
        this.topicMidEnd = topicMidEnd;
    }

    public Date getTopicFinalBegin() {
        return topicFinalBegin;
    }

    public void setTopicFinalBegin(Date topicFinalBegin) {
        this.topicFinalBegin = topicFinalBegin;
    }

    public Date getTopicFinalEnd() {
        return topicFinalEnd;
    }

    public void setTopicFinalEnd(Date topicFinalEnd) {
        this.topicFinalEnd = topicFinalEnd;
    }


    public Date getTopicCommitBegin() {
        return topicCommitBegin;
    }

    public void setTopicCommitBegin(Date topicCommitBegin) {
        this.topicCommitBegin = topicCommitBegin;
    }

    public Date getTopicCommitEnd() {
        return topicCommitEnd;
    }

    public void setTopicCommitEnd(Date topicCommitEnd) {
        this.topicCommitEnd = topicCommitEnd;
    }

    @Override
    public String toString() {
        return "TopicCheckProcess{" +
                "id=" + id +
                ", topicCommitBegin=" + topicCommitBegin +
                ", topicCommitEnd=" + topicCommitEnd +
                ", choiceBegin=" + choiceBegin +
                ", choiceEnd=" + choiceEnd +
                ", topicBegin=" + topicBegin +
                ", topicEnd=" + topicEnd +
                ", topicMidBegin=" + topicMidBegin +
                ", topicMidEnd=" + topicMidEnd +
                ", topicFinalBegin=" + topicFinalBegin +
                ", topicFinalEnd=" + topicFinalEnd +
                '}';
    }
}
