package com.axonivy.demo.patterndemos.paralleltasks;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.process.model.value.SignalCode;
import ch.ivyteam.ivy.security.exec.Sudo;
import ch.ivyteam.ivy.workflow.ITask;
import ch.ivyteam.ivy.workflow.TaskState;
import ch.ivyteam.ivy.workflow.query.TaskQuery;

public class ParallelTasksDemoService {
	private static final ParallelTasksDemoService INSTANCE = new ParallelTasksDemoService();

	/**
	 * Returns instance of the class.
	 *
	 * @return FundingApplicationService
	 */
	public static ParallelTasksDemoService get() {
		return INSTANCE;
	}

	public void startParallelTasks() {
		var iterationCount = 4;
		var signalCode = new SignalCode("com:axonivy:demo:patterndemos:paralleltasks:startParallelTask");
		var caseId = String.valueOf(Ivy.wfCase().getId());

		for (var i = 0; i < iterationCount; i++) {

			Ivy.wf().signals().create().data(caseId).makeCurrentTaskPersistent().send(signalCode);
		}
	}

	/**
	 * Sends a signal to cancel other add agenda items of {@link Meeting}.
	 *
	 * @param meeting
	 */
	public void signalDemoParallelTasksCancel(String caseId) {
		Ivy.wf().signals().send("com:axonivy:demo:patterndemos:paralleltasks:cancelParallelTasks" + ":" + caseId);
	}

	/**
	 * Sends a signal if the add agenda items of {@link Meeting} is done.
	 *
	 * @param meeting
	 */
	public void signalCheckDemoParallelDone(String caseId) {
		var respondedAll = (anyAddAgendaItemTasks(caseId) == false);
		if(respondedAll) {
			Ivy.wf().signals().send(new SignalCode("com:axonivy:demo:patterndemos:paralleltasks:continueAfterParallelTask" + ":" + caseId));
		}
	}

	/**
	 * Checks if exists any add agenda items for {@link Meeting}.
	 *
	 * @param caseId
	 * @return boolean
	 */
	public boolean anyAddAgendaItemTasks(String caseId) {
		return anyActiveDemoTaskByCustomField(caseId, "demoParallelTask", Boolean.TRUE.toString());
	}

	/**
	 * Check if any active task of Meeting process with custom field and value presented.
	 *
	 * @param meetingId
	 * @param customField
	 * @param customFieldValue
	 * @return boolean
	 */
	public boolean anyActiveDemoTaskByCustomField(String caseId, String customField, String customFieldValue) {
		return CollectionUtils.isNotEmpty(findActiveTasksByCaseAndCustomeField(caseId, customField, customFieldValue));
	}

	/**
	 * Find tasks that are active for the meeting param with specific custom field and value.
	 *
	 * @param caseId
	 * @param customField
	 * @param customFieldValue
	 * @return
	 */
	public List<ITask> findActiveTasksByCaseAndCustomeField(String caseId, String customField, String customFieldValue) {
		return Sudo.get(() -> {
			return TaskQuery.create().where().customField().stringField("caseId").isEqual(caseId)
					.and().customField().stringField(customField).isEqual(customFieldValue)
					.and(getTaskQueryForRunningTasks()).executor().results();
		});
	}

	/**
	 * Get query for running tasks.
	 *
	 * @return
	 */
	private TaskQuery getTaskQueryForRunningTasks() {
		return TaskQuery.create().where().state().isNotEqual(TaskState.DONE).and().state().isNotEqual(TaskState.DESTROYED);
	}

}
