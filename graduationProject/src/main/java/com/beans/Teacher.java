package com.beans;

import com.utils.RoleUtils;

import javax.management.relation.Role;

/**
 * Created by wuhao on 16/4/17.
 */
public class Teacher {
    public long id;
    public String teacher_id;
    public String uid;
    public String teacher_no;
    public String name;
    public String college_name;
    public String major_name;
    public String tel_no;
    public String email;
    public String qq_no;
    public int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTeacher_no() {
        return teacher_no;
    }

    public void setTeacher_no(String teacher_no) {
        this.teacher_no = teacher_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq_no() {
        return qq_no;
    }

    public void setQq_no(String qq_no) {
        this.qq_no = qq_no;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Teacher() {
        this.teacher_id= RoleUtils.genId();
        this.status = 1;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacher_id='" + teacher_id + '\'' +
                ", uid='" + uid + '\'' +
                ", teacher_no='" + teacher_no + '\'' +
                ", name='" + name + '\'' +
                ", college_name='" + college_name + '\'' +
                ", major_name='" + major_name + '\'' +
                ", tel_no='" + tel_no + '\'' +
                ", email='" + email + '\'' +
                ", qq_no='" + qq_no + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
