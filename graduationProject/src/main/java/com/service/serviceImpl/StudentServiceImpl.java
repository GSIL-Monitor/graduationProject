package com.service.serviceImpl;

import com.beans.*;

import com.dao.*;
import com.opensymphony.xwork2.ActionContext;
import com.service.StudentService;
import com.utils.FileUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wuhao on 16/4/17.
 */
public class StudentServiceImpl implements StudentService{
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private StudentDao studentDao;

    private TopicProcessDao topicProcessDao;

    private UserDao userDao;

    private TopicDao topicDao;

    private TopicStatusDao topicStatusDao;

    private TopicFinalInfoDao topicFinalInfoDao;

    private TopicThirdSugDao topicThirdSugDao;

    public TopicStatusDao getTopicStatusDao() {
        return topicStatusDao;
    }

    public void setTopicStatusDao(TopicStatusDao topicStatusDao) {
        this.topicStatusDao = topicStatusDao;
    }

    public TopicFinalInfoDao getTopicFinalInfoDao() {
        return topicFinalInfoDao;
    }

    public void setTopicFinalInfoDao(TopicFinalInfoDao topicFinalInfoDao) {
        this.topicFinalInfoDao = topicFinalInfoDao;
    }

    public TopicThirdSugDao getTopicThirdSugDao() {
        return topicThirdSugDao;
    }

    public void setTopicThirdSugDao(TopicThirdSugDao topicThirdSugDao) {
        this.topicThirdSugDao = topicThirdSugDao;
    }

    public TopicDao getTopicDao() {
        return topicDao;
    }

    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    public TopicProcessDao getTopicProcessDao() {
        return topicProcessDao;
    }

    public void setTopicProcessDao(TopicProcessDao topicProcessDao) {
        this.topicProcessDao = topicProcessDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void update(Student student)  {
        try {
            User user = (User)ActionContext.getContext().getSession().get("user");
            student.setUid(user.getUser_id());
            studentDao.updateStudent(student);
        }catch (Exception e){
           e.printStackTrace();
        }

    }
    public void lock(Student student) {
        try {
            studentDao.lockStudent(student);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void selectTopic(Student student,Topic topic){
        try {
            if (student.getTopic_id()!=null){
                topicDao.unLockTopic(student.getTopic_id());
            }
            topic.setIs_selected(1);
            student.setTopic_id(topic.getTopic_id());
            studentDao.selectTopic(student);
            topicDao.lockTopic(topic.getTopic_id());
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    public void add(Student student,User user) {
        try {
            user.setPassword("123456");
            user.setType(1);
            student.setUid(user.getUser_id());
            studentDao.saveStudent(student);
            userDao.saveUser(user);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    public List queryall() {
        List list=new ArrayList();
        try {
            list=studentDao.queryAllStudents();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return list;
    }
    public List queryallByMajorName(String majorName){
        List list=new ArrayList();
        try {
            list=studentDao.queryAllByMajorName(majorName);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return list;
    }
    public Student getStudent(String uid) {
        Student student=new Student();
        try {
            student=studentDao.getStudent(uid);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return student;
    }

    public Student getStudentByid(long id) {
        Student student=new Student();
        try {
            student=studentDao.getStudentByid(id);
            System.out.println(student.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }

    public void addPer(TopicProcess topicProcess) {
        try {
            FileUtils.saveper("student", JSONObject.fromObject(topicProcess).toString());
            topicProcessDao.saveTopicProcess(topicProcess);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
    public TopicProcess getPer() {
        TopicProcess topicProcess=null;
        try {
            topicProcess=topicProcessDao.get();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return topicProcess;
    }
    public TopicThirdSug getSug(String uid) {
        try {
            Student student=studentDao.getStudent(uid);
            if (student.getTopic_id()!=null){
                TopicThirdSug topicThirdSug= topicThirdSugDao.getTopicThirdSugByTopicId(student.getTopic_id());
                return topicThirdSug;
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }

        return null;
    }
    public TopicFinalInfo getFinalInfo(Student student) {
        try {
            TopicFinalInfo topicFinalInfo=topicFinalInfoDao.getTopicFinalInfoByTopicId(student.getTopic_id());
            return topicFinalInfo;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public TopicStatus getStatus(Student student){
        try {
            TopicStatus topicStatus=topicStatusDao.getTopicStatusByTopicId(student.getTopic_id());
            return topicStatus;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void commitFinal(Student student,File word,File pdf,String wordName,String pdfName){
        try{
            TopicStatus topicStatus=topicStatusDao.getTopicStatusByTopicId(student.getTopic_id());
            TopicFinalInfo topicFinalInfo=topicFinalInfoDao.getTopicFinalInfoByTopicId(student.getTopic_id());
            if (word!=null){
                topicFinalInfo.setIsSaveWord(1);
                topicFinalInfo.setWordName(FileUtils.formatFileName(wordName));
                FileUtils.saveFile(wordName,word);
            }
            if (pdf!=null){
                topicFinalInfo.setIsSavePdf(1);
                topicFinalInfo.setPdfName(FileUtils.formatFileName(pdfName));
                FileUtils.saveFile(pdfName, pdf);
            }
            topicStatus.setTopicFinal(1);
            topicStatusDao.updateTopicStatus(topicStatus);
            topicFinalInfoDao.updateTopicFinalInfo(topicFinalInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
