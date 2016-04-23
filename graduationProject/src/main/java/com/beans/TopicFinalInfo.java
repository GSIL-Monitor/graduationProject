package com.beans;

/**
 * Created by wuhao on 16/4/21.
 */
public class TopicFinalInfo {
    public long id;
    public String topic_id;
    public String wordName;
    public String pdfName;
    public int isSaveWord;
    public int isSavePdf;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    public int getIsSaveWord() {
        return isSaveWord;
    }

    public void setIsSaveWord(int isSaveWord) {
        this.isSaveWord = isSaveWord;
    }

    public int getIsSavePdf() {
        return isSavePdf;
    }

    public void setIsSavePdf(int isSavePdf) {
        this.isSavePdf = isSavePdf;
    }

    @Override
    public String toString() {
        return "TopicFinalInfo{" +
                "id=" + id +
                ", topic_id='" + topic_id + '\'' +
                ", wordName='" + wordName + '\'' +
                ", pdfName='" + pdfName + '\'' +
                ", isSaveWord=" + isSaveWord +
                ", isSavePdf=" + isSavePdf +
                '}';
    }
}
