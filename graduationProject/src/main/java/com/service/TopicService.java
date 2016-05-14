package com.service;

import com.beans.*;
import com.dao.TopicDao;

import java.util.List;

/**
 * Created by wuhao on 16/4/16.
 */
public interface TopicService {

    public void update(Topic topic);

    public void save(Teacher teacher,Topic topic);

    public List getTopicByteacherId(String teacher_id,String sqlWhere);

    public Topic getTopicByTopicId(String topic_id);

    public List queryAllTopics(String sqlWhere);

    public TopicStatus getTopicStatus(String topic_id);

    public Report getTopicReport(String topic_id);

    public List queryAllTopicBymajorName(String majorName,String sqlWhere);

    public void commit(String topic_id,String comment,String step);

    public void reject(String topic_id,String step,String teacher_info);

    public void pass(String topic_id,int sorce,String step,String info);

    public TopicThirdSug getSug(String topic_id);

    public SumBean count(Teacher teacher);

    public TopicFinalInfo getTopicFinalInfoByTopicId(String topic_id);

    public TopicProcess getStudentPer();

    public TopicCheckProcess getTeacherPer();
}
