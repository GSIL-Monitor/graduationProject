package com.dao.impl;

import com.beans.Student;
import com.beans.Teacher;
import com.dao.StudentDao;
import com.dao.TeacherDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by wuhao on 16/4/17.
 */
public class TeacherDaoImpl implements TeacherDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveTeacher(Teacher teacher) throws Exception {
        Session session;//hibernate会话
        Transaction transaction; //hiberante事务
        session=sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();
        session.save(teacher);
        transaction.commit();
        session.close();
    }
    public Teacher getTeacherByTeacherId(String teacher_id) throws Exception {
        Teacher teacher=null;
        Session session;//hibernate会话
        session=sessionFactory.openSession();
        String selectHql="select teacher from Teacher as teacher where teacher.teacher_id=?";
        Query query=session.createQuery(selectHql);
        query.setString(0, teacher_id);
        List<Teacher> list=query.list();
        if (!list.isEmpty()){
            teacher=list.get(0);
        }
        session.close();
        return teacher;
    }
    public Teacher getTeacherByUId(String uid) throws Exception {
        Teacher teacher=null;
        Session session;//hibernate会话
        session=sessionFactory.openSession();
        String selectHql="select teacher from Teacher as teacher where teacher.uid=?";
        Query query=session.createQuery(selectHql);
        query.setString(0,uid);
        List<Teacher> list=query.list();
        if (!list.isEmpty()){
            teacher=list.get(0);
        }
        session.close();
        return teacher;
    }

    public List queryAllTeacher() throws Exception {
        Session session;//hibernate会话
        session=sessionFactory.openSession();
        List list=session.createQuery("select teacher from Teacher as teacher where teacher.status=1").list();
        session.close();
        return list;
    }

    public void updateTeacher(Teacher teacher) throws Exception {
        Session session;//hibernate会话
        Transaction transaction; //hiberante事务
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        String selectHql="select teacher from Teacher as teacher where teacher.uid=?";
        Query query=session.createQuery(selectHql);
        query.setString(0,teacher.getUid());
        List<Teacher> list=query.list();
        if (!list.isEmpty()){
            Teacher teacherSql=list.get(0);
            teacherSql.setTel_no(teacher.getTel_no());
            teacherSql.setEmail(teacher.getEmail());
            teacherSql.setQq_no(teacher.getQq_no());
            teacherSql.setStatus(teacher.getStatus());
            session.update(teacherSql);
        }
        transaction.commit();
        session.close();
    }
    public void lockTeacher(Teacher teacher) throws Exception{
        Session session;//hibernate会话
        Transaction transaction; //hiberante事务
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        String selectHql="select teacher from Teacher as teacher where teacher.uid=?";
        Query query=session.createQuery(selectHql);
        query.setString(0,teacher.getUid());
        List<Teacher> list=query.list();
        if (!list.isEmpty()){
            Teacher teacherSql=list.get(0);
            teacherSql.setStatus(teacher.getStatus());
            session.update(teacherSql);
        }
        transaction.commit();
        session.close();
    }
}
