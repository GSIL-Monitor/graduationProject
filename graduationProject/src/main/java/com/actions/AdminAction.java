package com.actions;

import com.beans.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.*;
import com.utils.RoleUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.List;
import java.util.Map;

public class AdminAction extends ActionSupport {
	private static final Logger logger = LoggerFactory.getLogger(AdminAction.class);

	private InputStream inputStream;

	private UserService userService;

	private TopicService topicService;

	private TeacherService teacherService;

	private StudentService studentService;

	private MessageService messageService;

	private Student student;

	private long student_id;

	private String teacher_id;

	private Teacher teacher;

	private Message message;

	private User user;

	private TopicProcess topicProcess;

	private int is_pass;

	private long message_id;

	private String topic_id;

	private File upload;

	private String uploadFileName;

	private String uploadContentType;

	private TopicCheckProcess topicCheckProcess;

	public long getMessage_id() {
		return message_id;
	}

	public void setMessage_id(long message_id) {
		this.message_id = message_id;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public MessageService getMessageService() {
		return messageService;
	}

	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(String topic_id) {
		this.topic_id = topic_id;
	}

	public TopicCheckProcess getTopicCheckProcess() {
		return topicCheckProcess;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public int getIs_pass() {
		return is_pass;
	}

	public void setIs_pass(int is_pass) {
		this.is_pass = is_pass;
	}

	public void setTopicCheckProcess(TopicCheckProcess topicCheckProcess) {
		this.topicCheckProcess = topicCheckProcess;
	}

	public TopicProcess getTopicProcess() {
		return topicProcess;
	}

	public void setTopicProcess(TopicProcess topicProcess) {
		this.topicProcess = topicProcess;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public String stuAdd(){
		String errorMsg=studentService.checkstudent(student,user);
		if(errorMsg!=null) {
			ActionContext.getContext().getSession().put("errorMsg", errorMsg);
			return "STU_CREATE";
		}
		studentService.add(student,user);
		return "home";
	}
	public String teaAdd() {
		String errorMsg=teacherService.checkTeacher(teacher,user);
		if(errorMsg!=null) {
			ActionContext.getContext().getSession().put("errorMsg", errorMsg);
			return "TEA_CREATE";
		}

		teacherService.add(teacher, user);
		return "home";
	}
	public String stuDelete(){
		student =studentService.getStudentByid(student_id);
		student.setStatus(0);
		user=userService.getUser(student.getUid());
		user.setStatus(0);
		studentService.lock(student);
		System.out.println("user:"+user.toString());
		userService.update(user);
		return "STU_DELETE";
	}
	public String teaDelete(){
		teacher=teacherService.getTeacherByteacherId(teacher_id);
		teacher.setStatus(0);
		user=userService.getUser(teacher.getUid());
		user.setStatus(0);
		teacherService.lock(teacher);
		System.out.println("user:" + user.toString());
		userService.update(user);
		return "TEA_DELETE";
	}
	public String stuCreate(){
		ActionContext.getContext().getSession().remove("errorMsg");
		return "STU_CREATE";
	}
	public String stuUpdate(){
		List studentList = studentService.queryall();
		ActionContext.getContext().getSession().put("studentList",studentList);
		return "STU_UPDATE";
	}
	public String stuModify() {
		ActionContext.getContext().getSession().put("student_id", student_id);
		return "STU_MODIFY";
	}
	public String stuModifyVal() {
		Map session = ActionContext.getContext().getSession();
		Object student_id = session.get("student_id");
		student = studentService.getStudentByid(Long.parseLong(student_id.toString()));
		String studentJson = RoleUtils.transcoding(JSONObject.fromObject(student).toString());
		inputStream = new StringBufferInputStream(studentJson);
		return SUCCESS;
	}
	public String teaModify() {
		ActionContext.getContext().getSession().put("teacher_id",teacher_id);
		return "TEA_MODIFY";
	}
	public String teaModifyVal() {
		teacher_id=(String)ActionContext.getContext().getSession().get("teacher_id");
		teacher=teacherService.getTeacherByteacherId(teacher_id);
		String teacherJson= RoleUtils.transcoding(JSONObject.fromObject(teacher).toString());
		inputStream = new StringBufferInputStream(teacherJson);
		return SUCCESS;
	}
	public String teaCreate(){
		ActionContext.getContext().getSession().remove("errorMsg");
		return "TEA_CREATE";
	}
	public String teaUpdate(){
		List teachertList = teacherService.queryall();
		ActionContext.getContext().getSession().put("teachertList",teachertList);
		return "TEA_UPDATE";
	}
	public String studentPer() {
		topicProcess=topicService.getStudentPer();
		ActionContext.getContext().getSession().put("topicProcess",topicProcess);
		return "STUDENT_PER";
	}
	public String teacherPer(){
		topicCheckProcess=topicService.getTeacherPer();
		ActionContext.getContext().getSession().put("topicCheckProcess",topicCheckProcess);
		return "TEACHER_PER";
	}
	public String stuPer() {
		studentService.addPer(topicProcess);
		return "home";
	}
	public String teaPer() {
		teacherService.addPer(topicCheckProcess);
		return "home";
	}
	public String change() {
		return "change";
	}
	public String topicCheck() {
		Topic topic =topicService.getTopicByTopicId(topic_id);
		if (is_pass==1){
			topic.setStatus(2);
		}else {
			topic.setStatus(0);
		}
		topicService.update(topic);
		return "topicCheck";
	}
	public String check() {
		String sqlWhere="topic.status=1";
		List topicList=topicService.queryAllTopics(sqlWhere);
		ActionContext.getContext().getSession().put("topicList", topicList);
		return "check";
	}
	public String messageCreate() {
		ActionContext.getContext().getSession().remove("errorMsg");
		return "MSG_CRE";
	}
	public String msgCreate() {
		if ( message.getTitle().equals("")){
			ActionContext.getContext().getSession().put("errorMsg","标题不能为空");
			return "MSG_CRE";
		}
		if ( message.getContent().equals("")){
			ActionContext.getContext().getSession().put("errorMsg","内容不能为空");
			return "MSG_CRE";
		}
		messageService.save(message,upload,uploadFileName);
		return "CRE_MSG";
	}
	public String msgDelete() {
		message=messageService.get(message_id);
		message.setStatus(0);
		messageService.update(message);
		return "MSG_DEL";
	}
	public String msgList() {
		List messageList=messageService.queryAllMessages();
		System.out.println("msg len:"+messageList.size());
		ActionContext.getContext().getSession().put("messageList",messageList);
		return "MSG_LIST";
	}
	public String home() {
		TopicCheckProcess topicCheckProcess=teacherService.getPer();
		SumBean sumBean=userService.count();
		ActionContext.getContext().getSession().put("topicCheckProcess",topicCheckProcess);
		ActionContext.getContext().getSession().put("sumBean",sumBean);
		return "home";
	}
	public String stuUpd(){
		return "home";
	}
	public String teaUpd(){
		return "home";
	}
}
