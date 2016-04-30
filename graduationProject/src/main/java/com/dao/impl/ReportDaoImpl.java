package com.dao.impl;

import com.beans.Report;
import com.beans.TopicThirdSug;
import com.dao.ReportDao;
import com.dao.TopicThirdSugDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


public class ReportDaoImpl implements ReportDao{
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveReport(Report report) throws Exception {
		Session session;//hibernate会话
		Transaction transaction; //hiberante事务
		session=sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.save(report);
		transaction.commit();
		session.close();
	}

	public Report getReportByTopicId(String topic_id) throws Exception {
		Report report=null;
		Session session;//hibernate会话
		session=sessionFactory.openSession();
		String selectHql="select report from Report as report where report.topic_id=?";
		Query query=session.createQuery(selectHql);
		query.setString(0, topic_id);
		List<Report> list=query.list();
		if (!list.isEmpty()){
			report=list.get(0);
		}
		session.close();
		return report;
	}

	public void updateReport(Report report) throws Exception {
		Session session;//hibernate会话
		Transaction transaction; //hiberante事务
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		String selectHql="select report from Report as report where report.topic_id=?";
		Query query=session.createQuery(selectHql);
		query.setString(0,report.getTopic_id());
		List<Report> list=query.list();
		if (!list.isEmpty()){
			Report sqlreport=list.get(0);
			sqlreport.setBeginReport(report.getBeginReport());
			sqlreport.setMidReport(report.getMidReport());
			session.update(sqlreport);
		}
		transaction.commit();
		session.close();
	}
}
