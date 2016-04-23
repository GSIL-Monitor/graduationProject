package com.beans;

/**
 * Created by wuhao on 16/4/17.
 */
public class Student {
    private long id;
    private String topic_id;
    private String uid;
    private String stuNo;
    private String name;
    private String collegeName;
    private String majorName;
    private String grade;
    private String className;
    private String telNo;
    private String email;
    private String qqNo;
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQqNo() {
        return qqNo;
    }

    public void setQqNo(String qqNo) {
        this.qqNo = qqNo;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public Student() {
        this.status = 1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", topic_id='" + topic_id + '\'' +
                ", stuNo='" + stuNo + '\'' +
                ", name='" + name + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", majorName='" + majorName + '\'' +
                ", grade='" + grade + '\'' +
                ", className='" + className + '\'' +
                ", telNo='" + telNo + '\'' +
                ", email='" + email + '\'' +
                ", qqNo='" + qqNo + '\'' +
                ", status=" + status +
                ", uid='" + uid + '\'' +
                '}';
    }
}
