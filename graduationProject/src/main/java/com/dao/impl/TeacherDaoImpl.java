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
    }

    public List queryAllTeacher() throws Exception {
        Session session;//hibernate会话
        session=sessionFactory.openSession();
        List list=session.createQuery("select teacher from Teacher as teacher").list();
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
        List<Student> list=query.list();
        if (!list.isEmpty()){
            Student studentSql=list.get(0);
            studentSql.setTelNo(teacher.getTel_no());
            studentSql.setEmail(teacher.getEmail());
            studentSql.setQqNo(teacher.getQq_no());
            session.update(studentSql);
        }
        transaction.commit();
        session.close();
    }
}
