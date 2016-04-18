package com.beans;

/**
 * Created by wuhao on 16/4/17.
 */
public class Student {
    private long id;
    private String stuNo;
    private String name;
    private String collegeName;
    private String majorName;
    private String grade;
    private String className;
    private String telNo;
    private String email;
    private String qqNo;
    private long uid;

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

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuNo='" + stuNo + '\'' +
                ", name='" + name + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", majorName='" + majorName + '\'' +
                ", grade='" + grade + '\'' +
                ", className='" + className + '\'' +
                ", telNo='" + telNo + '\'' +
                ", email='" + email + '\'' +
                ", qqNo='" + qqNo + '\'' +
                ", uId='" + uid + '\'' +
                '}';
    }
}
