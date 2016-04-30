package com.dao;

import com.beans.Report;

public interface ReportDao {

	public void saveReport(Report report) throws Exception;

	public Report getReportByTopicId(String topic_id) throws Exception;

	public void updateReport(Report report) throws Exception;


	
}
