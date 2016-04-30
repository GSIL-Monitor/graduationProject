package com.beans;

/**
 * Created by wuhao on 16/4/29.
 */
public class SumBean {
    private long studentCount;
    private long teacherCount;
    private long topicCount;
    private long topicPendingCount;

    public long getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(long studentCount) {
        this.studentCount = studentCount;
    }

    public long getTeacherCount() {
        return teacherCount;
    }

    public void setTeacherCount(long teacherCount) {
        this.teacherCount = teacherCount;
    }

    public long getTopicCount() {
        return topicCount;
    }

    public void setTopicCount(long topicCount) {
        this.topicCount = topicCount;
    }

    public long getTopicPendingCount() {
        return topicPendingCount;
    }

    public void setTopicPendingCount(long topicPendingCount) {
        this.topicPendingCount = topicPendingCount;
    }

    @Override
    public String toString() {
        return "SumBean{" +
                "studentCount=" + studentCount +
                ", teacherCount=" + teacherCount +
                ", topicCount=" + topicCount +
                ", topicPendingCount=" + topicPendingCount +
                '}';
    }
}
