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
        try {
            List list=studentDao.queryAllByMajorName(majorName);
            if (!list.isEmpty()) {
                return list;
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return new ArrayList();
    }
    public Student getStudent(String uid) {
        try {
            Student student=studentDao.getStudent(uid);
            if (student!=null){
                return student;
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return new Student();
    }

    public Student getStudentByid(long id) {
        try {
            Student student=studentDao.getStudentByid(id);
            if (student!=null){
                return student;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Student();
    }

    public void addPer(TopicProcess topicProcess) {
        try {
            System.out.println("topic"+topicProcess.toString());
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

        return new TopicThirdSug();
    }
    public TopicFinalInfo getFinalInfo(Student student) {
        try {
            TopicFinalInfo topicFinalInfo=topicFinalInfoDao.getTopicFinalInfoByTopicId(student.getTopic_id());
            if (topicFinalInfo!=null) {
                return topicFinalInfo;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new TopicFinalInfo();
    }
    public TopicStatus getStatus(Student student){
        try {
            TopicStatus topicStatus=topicStatusDao.getTopicStatusByTopicId(student.getTopic_id());
            if(topicStatus!=null){
                return topicStatus;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new TopicStatus();
    }
    public void commitFinal(Student student,File word,File pdf,String wordName,String pdfName){
        try{
            TopicStatus topicStatus=topicStatusDao.getTopicStatusByTopicId(student.getTopic_id());
            TopicFinalInfo topicFinalInfo=topicFinalInfoDao.getTopicFinalInfoByTopicId(student.getTopic_id());
            if (word!=null){
                topicFinalInfo.setIsSaveWord(1);
                wordName=FileUtils.formatFileName(wordName);
                topicFinalInfo.setWordName(wordName);
                FileUtils.saveFile(wordName,word);
            }
            if (pdf!=null){
                topicFinalInfo.setIsSavePdf(1);
                pdfName=FileUtils.formatFileName(pdfName);
                topicFinalInfo.setPdfName(pdfName);
                FileUtils.saveFile(pdfName, pdf);
            }
            topicStatus.setTopicFinal(1);
            topicStatusDao.updateTopicStatus(topicStatus);
            topicFinalInfoDao.updateTopicFinalInfo(topicFinalInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public String checkstudent(Student student,User user){
        String error=null;
        try {
            if (!userDao.UserIsExit(user.getUsername())){
                error="账号已存在";
            }
            if(user.getUsername().equals("")){
                error="账号不能为空";
            }
            if(user.getUsername().length()>40 || user.getUsername().length()<6){
                error="账号长度应在6-40之间";
            }
            if(user.getUsername().matches("^[0-9]*$")){
                error="账号不能是纯数字";
            }
            if (student.getName().equals("")){
                error="姓名不能为空";
            }
            if (student.getClassName().equals("")){
                error="班级不能为空";
            }
            if (student.getStuNo().equals("")){
                error="学号不能为空";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return error;
    }
}
