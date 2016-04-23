package com.beans;

import com.utils.RoleUtils;

import java.util.Date;

/**
 * Created by wuhao on 16/4/19.
 */
public class Topic {
    public long id;
    public String topic_id;
    //导师id
    public String teacherId;
    //论文题目
    public String name;
    //指导教师姓名
    public String tutorName;
    //题目对应专业
    public String majorName;
    //添加人
    public String created_by;
    //添加时间
    public int created_at;
    //修改人
    public String updated_by;
    //修改时间
    public int updated_at;
    //题目类别
    public String type;
    //题目性质
    public String physical;
    //是否实验类
    public String isTrial;
    //是否应用类
    public String isAnswer;
    //是否导师在研项目
    public String isTutorWork;
    //题目申报状态
    public int status;
    //题目说明
    public String instruction;
    //备注
    public String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public Topic() {
        Date now=new Date();
        this.status=1;
        this.topic_id= RoleUtils.genId();
        this.created_at=(int)(now.getTime()/1000);
        this.updated_at=(int)(now.getTime()/1000);
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", topic_id='" + topic_id + '\'' +
                ", teacherId='" + teacherId + '\'' +
                ", name='" + name + '\'' +
                ", tutorName='" + tutorName + '\'' +
                ", majorName='" + majorName + '\'' +
                ", created_by='" + created_by + '\'' +
                ", created_at=" + created_at +
                ", updated_by='" + updated_by + '\'' +
                ", updated_at=" + updated_at +
                ", type='" + type + '\'' +
                ", physical='" + physical + '\'' +
                ", isTrial='" + isTrial + '\'' +
                ", isAnswer='" + isAnswer + '\'' +
                ", isTutorWork='" + isTutorWork + '\'' +
                ", status=" + status +
                ", instruction='" + instruction + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
