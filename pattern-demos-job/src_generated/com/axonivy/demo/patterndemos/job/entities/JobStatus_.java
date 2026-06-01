package com.axonivy.demo.patterndemos.job.entities;

import com.axonivy.demo.patterndemos.job.enums.JobRunStatus;
import com.axonivy.utils.persistence.beans.AuditableIdEntity_;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.Instant;

/**
 * Static metamodel for {@link com.axonivy.demo.patterndemos.job.entities.JobStatus}
 **/
@StaticMetamodel(JobStatus.class)
public abstract class JobStatus_ extends AuditableIdEntity_ {

	
	/**
	 * @see #name
	 **/
	public static final String NAME = "name";
	
	/**
	 * @see #runStatus
	 **/
	public static final String RUN_STATUS = "runStatus";
	
	/**
	 * @see #startTime
	 **/
	public static final String START_TIME = "startTime";
	
	/**
	 * @see #endTime
	 **/
	public static final String END_TIME = "endTime";
	
	/**
	 * @see #lastSuccessStartTime
	 **/
	public static final String LAST_SUCCESS_START_TIME = "lastSuccessStartTime";
	
	/**
	 * @see #lastSuccessEndTime
	 **/
	public static final String LAST_SUCCESS_END_TIME = "lastSuccessEndTime";
	
	/**
	 * @see #message
	 **/
	public static final String MESSAGE = "message";
	
	/**
	 * @see #jobData
	 **/
	public static final String JOB_DATA = "jobData";

	
	/**
	 * Static metamodel type for {@link com.axonivy.demo.patterndemos.job.entities.JobStatus}
	 **/
	public static volatile EntityType<JobStatus> class_;
	
	/**
	 * Static metamodel for attribute {@link com.axonivy.demo.patterndemos.job.entities.JobStatus#name}
	 **/
	public static volatile SingularAttribute<JobStatus, String> name;
	
	/**
	 * Static metamodel for attribute {@link com.axonivy.demo.patterndemos.job.entities.JobStatus#runStatus}
	 **/
	public static volatile SingularAttribute<JobStatus, JobRunStatus> runStatus;
	
	/**
	 * Static metamodel for attribute {@link com.axonivy.demo.patterndemos.job.entities.JobStatus#startTime}
	 **/
	public static volatile SingularAttribute<JobStatus, Instant> startTime;
	
	/**
	 * Static metamodel for attribute {@link com.axonivy.demo.patterndemos.job.entities.JobStatus#endTime}
	 **/
	public static volatile SingularAttribute<JobStatus, Instant> endTime;
	
	/**
	 * Static metamodel for attribute {@link com.axonivy.demo.patterndemos.job.entities.JobStatus#lastSuccessStartTime}
	 **/
	public static volatile SingularAttribute<JobStatus, Instant> lastSuccessStartTime;
	
	/**
	 * Static metamodel for attribute {@link com.axonivy.demo.patterndemos.job.entities.JobStatus#lastSuccessEndTime}
	 **/
	public static volatile SingularAttribute<JobStatus, Instant> lastSuccessEndTime;
	
	/**
	 * Static metamodel for attribute {@link com.axonivy.demo.patterndemos.job.entities.JobStatus#message}
	 **/
	public static volatile SingularAttribute<JobStatus, String> message;
	
	/**
	 * Static metamodel for attribute {@link com.axonivy.demo.patterndemos.job.entities.JobStatus#jobData}
	 **/
	public static volatile SingularAttribute<JobStatus, String> jobData;

}

