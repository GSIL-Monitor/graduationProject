package com.dao.impl;

import com.beans.Student;
import com.beans.User;
import com.dao.StudentDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by wuhao on 16/4/17.
 */
public class StudentDaoImpl implements StudentDao{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveStudent(Student student) throws Exception {
        Session session;//hibernate会话
        Transaction transaction; //hiberante事务
        session=sessionFactory.openSession();
        transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
    }

    public List queryAllStudents() throws Exception {
        Session session;//hibernate会话
        session=sessionFactory.openSession();
        List list=session.createQuery("select stu from Student as stu where stu.status=1").list();
        session.close();
        return list;
    }
    public List queryAllByMajorName(String majorName) throws Exception {
        Session session;//hibernate会话
        session=sessionFactory.openSession();
        String selectHql="select stu from Student as stu where stu.majorName=?";
        Query query=session.createQuery(selectHql);
        query.setString(0,majorName);
        List list=query.list();
        session.close();
        return list;
    }
    public void updateStudent(Student student) throws Exception {
        Session session;//hibernate会话
        Transaction transaction; //hiberante事务
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        String selectHql="select stu from Student as stu where stu.uid=?";
        Query query=session.createQuery(selectHql);
        query.setString(0,student.getUid());
        List<Student> list=query.list();
        if (!list.isEmpty()){
            Student studentSql=list.get(0);
            studentSql.setTelNo(student.getTelNo());
            studentSql.setEmail(student.getEmail());
            studentSql.setQqNo(student.getQqNo());
            session.update(studentSql);
        }
        transaction.commit();
        session.close();
    }
    public void lockStudent(Student student) throws Exception {
        Session session;//hibernate会话
        Transaction transaction; //hiberante事务
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        String selectHql="select stu from Student as stu where stu.uid=?";
        Query query=session.createQuery(selectHql);
        query.setString(0,student.getUid());
        List<Student> list=query.list();
        if (!list.isEmpty()){
            Student studentSql=list.get(0);
            studentSql.setStatus(student.getStatus());
            session.update(studentSql);
        }
        transaction.commit();
        session.close();
    }
    public void selectTopic(Student student) throws Exception {
        Session session;//hibernate会话
        Transaction transaction; //hiberante事务
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        String selectHql="select stu from Student as stu where stu.uid=?";
        Query query=session.createQuery(selectHql);
        query.setString(0,student.getUid());
        List<Student> list=query.list();
        if (!list.isEmpty()){
            Student studentSql=list.get(0);
            studentSql.setTopic_id(student.getTopic_id());
            session.update(studentSql);
        }
        transaction.commit();
        session.close();
    }
    public Student getStudent(String uid) throws Exception {
        Session session;//hibernate会话
        session=sessionFactory.openSession();
        String selectHql="select stu from Student as stu where stu.uid=?";
        Query query=session.createQuery(selectHql);
        query.setString(0, uid);
        List<Student> list=query.list();
        session.close();
        if (!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    public Student getStudentByid(long id) throws Exception {
        Session session;//hibernate会话
        session=sessionFactory.openSession();
        String selectHql="select stu from Student as stu where stu.id=?";
        Query query=session.createQuery(selectHql);
        query.setLong(0, id);
        List<Student> list=query.list();
        session.close();
        if (!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }
    public Student getStudentByTopicId(String topic_id) throws Exception {
        Session session;//hibernate会话
        session=sessionFactory.openSession();
        String selectHql="select stu from Student as stu where stu.topic_id=?";
        Query query=session.createQuery(selectHql);
        query.setString(0,topic_id);
        List<Student> list=query.list();
        session.close();
        if (!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }
}
