package com.axonivy.demo.patterndemos.job.ui;

import java.time.Duration;

import com.axonivy.demo.patterndemos.job.service.JobService;

import ch.ivyteam.ivy.environment.Ivy;

public class JobBackgroundNoteCtrl {
	private String jobName;
	private String additionalJobData;
	private boolean execute;
	private boolean locked;

	public JobBackgroundNoteCtrl(String jobName, String additionalJobData) {
		this.jobName = jobName;
		this.additionalJobData = additionalJobData;
		locked = JobService.get().isLocked(jobName);
	}

	public void startJob() {
		Ivy.log().info("Manually starting job ''{0}'' with additional job data: ''{1}''", jobName, additionalJobData);
	}

	public void unlockJob() {
		Ivy.log().info("Manually unlocking job ''{0}''", jobName);
		boolean unlocked = JobService.get().forceUnlock(jobName, Duration.ofSeconds(10));
		if(!unlocked) {
			Ivy.log().info("Job ''{0}'' could not be unlocked. Please check the logs.", jobName);
		}
		locked = JobService.get().isLocked(jobName);
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the additionalJobData
	 */
	public String getAdditionalJobData() {
		return additionalJobData;
	}

	/**
	 * @param additionalJobData the additionalJobData to set
	 */
	public void setAdditionalJobData(String additionalJobData) {
		this.additionalJobData = additionalJobData;
	}

	/**
	 * @return the execute
	 */
	public boolean isExecute() {
		return execute;
	}

	/**
	 * @param execute the execute to set
	 */
	public void setExecute(boolean execute) {
		this.execute = execute;
	}

	/**
	 * @return the locked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * @param locked the locked to set
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
}
