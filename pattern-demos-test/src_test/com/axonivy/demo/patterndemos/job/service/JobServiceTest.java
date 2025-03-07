package com.axonivy.demo.patterndemos.job.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import com.axonivy.demo.patterndemos.job.entities.JobStatus;
import com.axonivy.demo.patterndemos.job.enums.JobRunStatus;
import com.axonivy.demo.patterndemos.job.pojos.ServiceResult;
import com.axonivy.demo.patterndemos.job.pojos.ServiceResult.ResultStatus;

import ch.ivyteam.ivy.environment.IvyTest;

@IvyTest
public class JobServiceTest {
	private JobService jobSvc = JobService.get();

	@Test
	public void testSimpleRun() {
		var jobName = "testJob";
		assertThat(jobSvc.loadJobStatus(jobName).getRunStatus()).isNull();
		assertThat(jobSvc.getJobLock(jobName)).isNull();

		assertThat(jobSvc.isLocked(jobName)).isFalse();
		ServiceResult result;
		result = jobSvc.runJob(jobName, true, Duration.ofMinutes(1), this::simpleJob);

		assertThat(jobSvc.isLocked(jobName)).isFalse();

		assertThat(result.isOk()).isTrue();
		var jobStatus = jobSvc.loadJobStatus(jobName);
		assertThat(jobStatus).isNotNull();
		assertThat(jobStatus.getRunStatus()).isEqualTo(JobRunStatus.OK);
	}

	private ServiceResult simpleJob(JobStatus lastJobStatus) {
		var result = new ServiceResult();
		result.add(ResultStatus.OK, "Everything is awesome!!!");
		return result;
	}

	@Test
	public void testRegisteredRun() {
		assertThat(jobSvc.loadJobStatus(DemoJobService.DEMO_JOB_NAME).getRunStatus()).isNull();
		assertThat(jobSvc.getJobLock(DemoJobService.DEMO_JOB_NAME)).isNull();

		assertThat(jobSvc.isLocked(DemoJobService.DEMO_JOB_NAME)).isFalse();
		ServiceResult result;

		result = jobSvc.runJob(DemoJobService.DEMO_JOB_NAME);

		assertThat(jobSvc.isLocked(DemoJobService.DEMO_JOB_NAME)).isFalse();

		assertThat(result.isOk()).isTrue();
		var jobStatus = jobSvc.loadJobStatus(DemoJobService.DEMO_JOB_NAME);
		assertThat(jobStatus).isNotNull();
		assertThat(jobStatus.getRunStatus()).isEqualTo(JobRunStatus.OK);
	}


}
