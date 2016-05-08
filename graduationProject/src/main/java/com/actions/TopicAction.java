package com.actions;

import com.beans.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.StudentService;
import com.service.TeacherService;
import com.service.TopicService;
import com.utils.RoleUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class TopicAction extends ActionSupport {
	private Topic topic;

	private String topic_id;

	private String teacher_info;

	private int is_pass;

	private int sorce;

	private TopicService topicService;

	private TeacherService teacherService;

	private StudentService studentService;

	public String getTeacher_info() {
		return teacher_info;
	}

	public void setTeacher_info(String teacher_info) {
		this.teacher_info = teacher_info;
	}

	public int getIs_pass() {
		return is_pass;
	}

	public void setIs_pass(int is_pass) {
		this.is_pass = is_pass;
	}

	public int getSorce() {
		return sorce;
	}

	public void setSorce(int sorce) {
		this.sorce = sorce;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public String getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(String topic_id) {
		this.topic_id = topic_id;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String detail(){
		System.out.println(topic_id);
		topic=topicService.getTopicByTopicId(topic_id);
		ActionContext.getContext().getSession().put("topic",topic);
		return "detail";
	}

	public String beginCheck() {
		Report report=topicService.getTopicReport(topic_id);
		ActionContext.getContext().getSession().put("report",report);
		return "BEGIN_CHECK";
	}
	public String beginRead() {
		Report report=topicService.getTopicReport(topic_id);
		TopicThirdSug topicThirdSug=topicService.getSug(topic_id);
		ActionContext.getContext().getSession().put("report",report);
		ActionContext.getContext().getSession().put("topicThirdSug",topicThirdSug);
		return "BEGIN_READ";
	}
	public String midCheck() {
		Report report=topicService.getTopicReport(topic_id);
		ActionContext.getContext().getSession().put("report",report);
		return "MID_CHECK";
	}
	public String midRead() {
		Report report=topicService.getTopicReport(topic_id);
		TopicThirdSug topicThirdSug=topicService.getSug(topic_id);
		ActionContext.getContext().getSession().put("report",report);
		ActionContext.getContext().getSession().put("topicThirdSug",topicThirdSug);
		return "MID_READ";
	}
	public String finalCheck() {
		TopicFinalInfo topicFinalInfo=topicService.getTopicFinalInfoByTopicId(topic_id);
		ActionContext.getContext().getSession().put("topicFinalInfo",topicFinalInfo);
		return "FINAL_CHECK";
	}
	public String input() throws Exception{
		Map session= ActionContext.getContext().getSession();
		User user=(User)session.get("user");
		Teacher teacher=teacherService.getTeacherByUid(user.getUser_id());
		topicService.save(teacher, topic);
		return "home";
	}
	public String select(){
		Map session=ActionContext.getContext().getSession();
		Student student=(Student)session.get("student");
		User user=(User) session.get("user");
		Topic topic=topicService.getTopicByTopicId(topic_id);
		studentService.selectTopic(student, topic);
		return RoleUtils.checkRoleType(user.getType())+"_SELECT";
	}
	public String update() {
		Topic topicOld=topicService.getTopicByTopicId(topic.getTopic_id());
		topicOld.setName(topic.getName());
		topicOld.setType(topic.getType());
		topicOld.setPhysical(topic.getPhysical());
		topicOld.setIsTrial(topic.getIsTrial());
		topicOld.setIsAnswer(topic.getIsAnswer());
		topicOld.setIsTutorWork(topic.getIsTutorWork());
		topicService.update(topicOld);
		return "teacherHome";
	}
	public String beginSave(){
		if (is_pass==0){
			topicService.reject(topic_id, "begin",teacher_info);
		}else {
			topicService.pass(topic_id,sorce,"begin",teacher_info);
		}
		return "teacherHome";
	}
	public String midSave(){
		if (is_pass==0){
			topicService.reject(topic_id, "mid",teacher_info);
		}else {
			topicService.pass(topic_id,sorce,"mid",teacher_info);
		}
		return "teacherHome";
	}
	public String finalSave(){
		if (is_pass==0){
			topicService.reject(topic_id, "final",teacher_info);
		}else {
			topicService.pass(topic_id,sorce,"final",teacher_info);
		}
		return "teacherHome";
	}

}
