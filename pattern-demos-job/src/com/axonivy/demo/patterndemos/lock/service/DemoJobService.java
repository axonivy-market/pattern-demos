package com.axonivy.demo.patterndemos.lock.service;

import com.axonivy.demo.patterndemos.lock.entities.JobStatus;
import com.axonivy.demo.patterndemos.lock.pojos.ServiceResult;
import com.axonivy.demo.patterndemos.lock.pojos.ServiceResult.ResultStatus;

import ch.ivyteam.ivy.environment.Ivy;

/**
 * Demo job service which will be called by Demo cron job process.
 */
public class DemoJobService {
	private static final DemoJobService INSTANCE = new DemoJobService();

	public static final String DEMO_JOB_NAME = "demojob.job";

	static {
		JobService.get().registerJobDescription(DEMO_JOB_NAME, (jobStatus) -> get().demoJob(jobStatus));
	}

	private DemoJobService() {
	}

	/**
	 * Get a service instance.
	 *
	 * @return
	 */
	public static DemoJobService get() {
		return INSTANCE;
	}

	/**
	 * Handle the logic of demo job.
	 *
	 */
	public ServiceResult demoJob(JobStatus lastJobStatus) {
		var result = new ServiceResult();

		try {
			Ivy.log().info("The cronjob demo triggered.");
			result.add(ResultStatus.OK, "Demo job finished sucessful.");
		} catch (Exception e) {
			result.add(ResultStatus.ERROR, "Error by the job of ''{0}''.", e, DEMO_JOB_NAME);
		}

		return result;
	}
}
