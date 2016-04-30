package com.beans;

import java.util.Date;

/**
 * Created by wuhao on 16/4/19.
 */
public class Message {
    public long id;
    public String title;
    public int status;
    public String content;
    public Date createAt;
    public int accessTimes;
    public int isHaveDoc;
    public String docName;
    public String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getAccessTimes() {
        return accessTimes;
    }

    public void setAccessTimes(int accessTimes) {
        this.accessTimes = accessTimes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIsHaveDoc() {
        return isHaveDoc;
    }

    public void setIsHaveDoc(int isHaveDoc) {
        this.isHaveDoc = isHaveDoc;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public Message() {
        this.createAt=new Date();
        this.status = 1;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", content='" + content + '\'' +
                ", createAt=" + createAt +
                ", accessTimes=" + accessTimes +
                ", isHaveDoc=" + isHaveDoc +
                ", docName='" + docName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
