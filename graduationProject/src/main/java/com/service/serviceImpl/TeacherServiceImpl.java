package com.service.serviceImpl;

import com.beans.*;
import com.dao.*;
import com.opensymphony.xwork2.ActionContext;
import com.service.StudentService;
import com.service.TeacherService;
import com.utils.FileUtils;
import com.utils.RoleUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuhao on 16/4/17.
 */
public class TeacherServiceImpl implements TeacherService{
    private static final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);

    private TeacherDao teacherDao;

    private UserDao userDao;

    private TopicDao topicDao;

    private StudentDao studentDao;

    private TopicStatusDao topicStatusDao;

    private TopicCheckProcessDao topicCheckProcessDao;

    public TopicStatusDao getTopicStatusDao() {
        return topicStatusDao;
    }

    public void setTopicStatusDao(TopicStatusDao topicStatusDao) {
        this.topicStatusDao = topicStatusDao;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public TopicCheckProcessDao getTopicCheckProcessDao() {
        return topicCheckProcessDao;
    }

    public void setTopicCheckProcessDao(TopicCheckProcessDao topicCheckProcessDao) {
        this.topicCheckProcessDao = topicCheckProcessDao;
    }

    public TopicDao getTopicDao() {
        return topicDao;
    }

    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public TeacherDao getTeacherDao() {
        return teacherDao;
    }

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    public void update(Teacher teacher)  {
        try {
            User user = (User)ActionContext.getContext().getSession().get("user");
            teacher.setUid(user.getUser_id());
            teacherDao.updateTeacher(teacher);
        }catch (Exception e){
            logger.error(e.getMessage());
        }

    }

    public void add(Teacher teacher,User user) {
        try {
            user.setType(2);
            user.setPassword("123456");
            teacher.setUid(user.getUser_id());
            userDao.saveUser(user);
            teacherDao.saveTeacher(teacher);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
    public Teacher getTeacherByteacherId(String teacher_id) {
        Teacher teacher=null;
        try {
            teacher=teacherDao.getTeacherByTeacherId(teacher_id);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return teacher;
    }
    public Teacher getTeacherByUid(String uid) {
        Teacher teacher=null;
        try {
            teacher=teacherDao.getTeacherByUId(uid);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return teacher;
    }

    public void addPer(TopicCheckProcess topicCheckProcess) {
        try {
            FileUtils.saveper("teacher", JSONObject.fromObject(topicCheckProcess).toString());
            topicCheckProcessDao.saveTopicCheckProcess(topicCheckProcess);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    public TopicCheckProcess getPer() {
        TopicCheckProcess topicCheckProcess=null;
        try {
            topicCheckProcess=topicCheckProcessDao.get();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return topicCheckProcess;
    }

    public List queryall() {
        List list=new ArrayList();
        try {
            list=teacherDao.queryAllTeacher();
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return list;
    }
    public void lock(Teacher teacher){
        try {
            teacherDao.lockTeacher(teacher);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List getCheckList(String teacher_id,String statusSql){
        List checkList=new ArrayList();
        CheckBean checkBean=new CheckBean();
        try {
            List<Topic> TopicList= topicDao.queryAllTopicsByStatus(teacher_id,statusSql);
            for(Topic topic:TopicList){
                Student student=studentDao.getStudentByTopicId(topic.getTopic_id());
                checkBean.setTopic_id(topic.getTopic_id());
                checkBean.setStudentName(student.getName());
                checkBean.setStudentNo(student.getStuNo());
                checkBean.setThesisName(topic.getName());
                checkList.add(checkBean);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return checkList;
    }
    public List getProcessList(String teacher_id){
        List processList=new ArrayList();
        String statusSql="1=1";
        ProcessBean processBean=new ProcessBean();
        try {
            List<Topic> TopicList= topicDao.queryAllTopicsByStatus(teacher_id,statusSql);
            for(Topic topic:TopicList){
                Student student=studentDao.getStudentByTopicId(topic.getTopic_id());
                TopicStatus topicStatus=topicStatusDao.getTopicStatusByTopicId(topic.getTopic_id());
                processBean.setTopic_id(topic.getTopic_id());
                processBean.setThesisName(topic.getName());
                processBean.setStudentNo(student.getStuNo());
                processBean.setStudentName(student.getName());
                processBean.setTopicBegin(RoleUtils.covent(topicStatus.getTopicBegin()));
                processBean.setTopicMid(RoleUtils.covent(topicStatus.getTopicMid()));
                processBean.setTopicEnd(RoleUtils.covent(topicStatus.getTopicFinal()));
                processList.add(processBean);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return processList;
    }
}
