package com.service.serviceImpl;

import com.beans.*;
import com.dao.*;
import com.opensymphony.xwork2.ActionContext;
import com.service.TopicService;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by wuhao on 16/4/16.
 */
public class TopicServiceImpl implements TopicService{
    private static final Logger logger = LoggerFactory.getLogger(TopicServiceImpl.class);
    private TopicDao topicDao;

    private TopicStatusDao topicStatusDao;

    private TopicThirdSugDao topicThirdSugDao;

    private TopicFinalInfoDao topicFinalInfoDao;

    private ReportDao reportDao;

    public TopicFinalInfoDao getTopicFinalInfoDao() {
        return topicFinalInfoDao;
    }

    public void setTopicFinalInfoDao(TopicFinalInfoDao topicFinalInfoDao) {
        this.topicFinalInfoDao = topicFinalInfoDao;
    }

    public ReportDao getReportDao() {
        return reportDao;
    }

    public void setReportDao(ReportDao reportDao) {
        this.reportDao = reportDao;
    }

    public TopicThirdSugDao getTopicThirdSugDao() {
        return topicThirdSugDao;
    }

    public void setTopicThirdSugDao(TopicThirdSugDao topicThirdSugDao) {
        this.topicThirdSugDao = topicThirdSugDao;
    }

    public TopicStatusDao getTopicStatusDao() {
        return topicStatusDao;
    }

    public void setTopicStatusDao(TopicStatusDao topicStatusDao) {
        this.topicStatusDao = topicStatusDao;
    }

    public TopicDao getTopicDao() {
        return topicDao;
    }

    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }


    public void update(Topic topic) {
        try {
            topicDao.updateTopic(topic);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    public void save(Teacher teacher,Topic topic) {
        try {
            TopicStatus topicStatus =new TopicStatus();
            TopicThirdSug topicThirdSug=new TopicThirdSug();
            TopicFinalInfo topicFinalInfo =new TopicFinalInfo();
            Report report=new Report();
            topicStatus.setTopicId(topic.getTopic_id());
            topicThirdSug.setTopic_id(topic.getTopic_id());
            topicFinalInfo.setTopic_id(topic.getTopic_id());
            report.setTopic_id(topic.getTopic_id());
            topic.setTutorName(teacher.getName());
            topic.setCreated_by(teacher.getName());
            topic.setUpdated_by(teacher.getName());
            topic.setMajorName(teacher.getMajor_name());
            topic.setTeacherId(teacher.getTeacher_id());
            topicDao.saveTopic(topic);
            topicStatusDao.saveTopicStatus(topicStatus);
            topicThirdSugDao.saveTopicThirdSug(topicThirdSug);
            topicFinalInfoDao.saveTopicFinalInfo(topicFinalInfo);
            reportDao.saveReport(report);
        }catch (Exception e){
            logger.error(e.getMessage());
        }

    }

    public List queryAllTopics(String sqlWhere) {
        List list=new ArrayList();
        try {
            list= topicDao.queryAllTopics(sqlWhere);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return list;
    }
    public List queryAllTopicBymajorName(String majorName,String sqlWhere) {
        List list=new ArrayList();
        try {
            list= topicDao.queryAllTopicBymajorName(majorName,sqlWhere);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return list;
    }

    public List getTopicByteacherId(String teacher_id,String sqlWhere) {
        List list=new ArrayList();
        try {
           list= topicDao.getTopicByTeacherId(teacher_id, sqlWhere);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return list;
    }
    public Topic getTopicByTopicId(String topic_id) {
        Topic topic=new Topic();
        try {
            topic= topicDao.getTopicByTopicId(topic_id);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return topic;
    }
    public Report getTopicReport(String topic_id) {
        Report report=new Report();
        try {
            report= reportDao.getReportByTopicId(topic_id);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return report;
    }
    public TopicStatus getTopicStatus(String topic_id){
        TopicStatus topicStatus=new TopicStatus();
        try {
            topicStatus= topicStatusDao.getTopicStatusByTopicId(topic_id);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return topicStatus;
    }
    public void commit(String topic_id,String comment,String step) {
        try{

            Report report=reportDao.getReportByTopicId(topic_id);
            TopicStatus topicStatus=topicStatusDao.getTopicStatusByTopicId(topic_id);
            if(step.equals("begin")) {
                topicStatus.setTopicBegin(1);
                report.setBeginReport(comment);
            }else if(step.equals("mid")){
                topicStatus.setTopicMid(1);
                report.setMidReport(comment);
            }else {
                topicStatus.setTopicFinal(1);
            }
            reportDao.updateReport(report);
            topicStatusDao.updateTopicStatus(topicStatus);
        }catch (Exception e){
           e.printStackTrace();
        }
    }

    public void reject(String topic_id,String step,String teacher_info) {
        try {
            TopicStatus topicStatus=topicStatusDao.getTopicStatusByTopicId(topic_id);
            TopicThirdSug topicThirdSug=topicThirdSugDao.getTopicThirdSugByTopicId(topic_id);
            if(step.equals("begin")) {
                topicStatus.setTopicBegin(0);
                topicThirdSug.setBegin_sug(teacher_info);
            }else if(step.equals("mid")){
                topicStatus.setTopicMid(0);
                topicThirdSug.setMid_sug(teacher_info);
            }else {
                topicStatus.setTopicFinal(0);
                topicThirdSug.setEnd_sug(teacher_info);
            }
            topicStatusDao.updateTopicStatus(topicStatus);
            topicThirdSugDao.updateTopicThirdSug(topicThirdSug);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void pass(String topic_id,int sorce,String step,String info){
        try {
            TopicStatus topicStatus=topicStatusDao.getTopicStatusByTopicId(topic_id);
            TopicThirdSug topicThirdSug=topicThirdSugDao.getTopicThirdSugByTopicId(topic_id);
            if (step.equals("begin")){
                topicStatus.setTopicBegin(2);
                topicStatus.setBeginScore(sorce);
                topicThirdSug.setBegin_sug(info);
            }else if(step.equals("mid")){
                topicStatus.setTopicMid(2);
                topicStatus.setMidScore(sorce);
                topicThirdSug.setMid_sug(info);
            }else {
                topicStatus.setTopicFinal(2);
                topicStatus.setFinalScore(sorce);
                topicThirdSug.setEnd_sug(info);
            }
            topicStatusDao.updateTopicStatus(topicStatus);
            topicThirdSugDao.updateTopicThirdSug(topicThirdSug);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public TopicThirdSug getSug(String topic_id){
        TopicThirdSug topicThirdSug=new TopicThirdSug();
        try {
            topicThirdSug=topicThirdSugDao.getTopicThirdSugByTopicId(topic_id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return topicThirdSug;
    }
    public SumBean count(Teacher teacher) {
        SumBean sumBean=new SumBean();
        try {
            sumBean.setTopicCount(topicDao.countTopicByteacher("1=1",teacher.getTeacher_id()));
            sumBean.setTopicPendingCount(topicDao.countTopicByteacher("status=1",teacher.getTeacher_id()));
            sumBean.setStudentCount(topicDao.countTopicByteacher("topic.topic_id in (select student.topic_id from Student as student where student.status=1)",teacher.getTeacher_id()));
            sumBean.setTeacherCount(topicDao.countTopicByteacher("topic.topic_id in (select topicStatus.topicId from TopicStatus as topicStatus where topicStatus.topicBegin=1 and topicStatus.topicMid=1 and topicStatus.topicFinal=1)",teacher.getTeacher_id()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return sumBean;
    }
    public TopicFinalInfo getTopicFinalInfoByTopicId(String topic_id) {
        TopicFinalInfo topicFinalInfo=new TopicFinalInfo();
        try {
            topicFinalInfo=topicFinalInfoDao.getTopicFinalInfoByTopicId(topic_id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return topicFinalInfo;
    }

}
