package com.service.serviceImpl;

import com.beans.Student;
import com.beans.Teacher;
import com.beans.User;
import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.opensymphony.xwork2.ActionContext;
import com.service.StudentService;
import com.service.TeacherService;
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

    public void add(Teacher teacher) {
        try {
            teacherDao.saveTeacher(teacher);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
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
}
