package com.beans;

/**
 * Created by wuhao on 16/4/24.
 */
public class TopicChange {
    private String topic_id;
    private String name;
    private String type;
    private String physical;
    private String isTrial;
    private String isAnswer;
    private String isTutorWork;

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhysical() {
        return physical;
    }

    public void setPhysical(String physical) {
        this.physical = physical;
    }

    public String getIsTrial() {
        return isTrial;
    }

    public void setIsTrial(String isTrial) {
        this.isTrial = isTrial;
    }

    public String getIsAnswer() {
        return isAnswer;
    }

    public void setIsAnswer(String isAnswer) {
        this.isAnswer = isAnswer;
    }

    public String getIsTutorWork() {
        return isTutorWork;
    }

    public void setIsTutorWork(String isTutorWork) {
        this.isTutorWork = isTutorWork;
    }
    public TopicChange(Topic topic){
        this.topic_id=topic.getTopic_id();
        this.type=topic.getType();
        this.isAnswer=topic.getIsAnswer();
        this.isTrial=topic.getIsTrial();
        this.isTutorWork=topic.getIsTutorWork();
        this.name=topic.getName();
        this.physical=topic.getPhysical();
    }
}
