package com.axonivy.demo.patterndemos.multistageescalation.utils;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.workflow.ITask;
import ch.ivyteam.ivy.workflow.WorkflowPriority;

public class TaskUtils {
	
	/**
	 * Configures the given task's priority and expiry timestamp based on the provided stage.
	 *
	 * <p>Configuration logic by stage:
	 * <ul>
	 *   <li><b>Stage 0, 1:</b> 
	 *       <ul>
	 *         <li>Priority: NORMAL</li>
	 *         <li>Expiry: current time + 1 minute</li>
	 *       </ul>
	 *   </li>
	 *   <li><b>Stage 2:</b> 
	 *       <ul>
	 *         <li>Priority: HIGH</li>
	 *         <li>Expiry: current time + 1 minute</li>
	 *       </ul>
	 *   </li>
	 *   <li><b>Stage 3:</b> 
	 *       <ul>
	 *         <li>Priority: EXCEPTION</li>
	 *         <li>Expiry: none (null)</li>
	 *       </ul>
	 *   </li>
	 *   <li><b>Default (any other stage):</b> 
	 *       <ul>
	 *         <li>Priority: NORMAL</li>
	 *         <li>Expiry: none (null)</li>
	 *       </ul>
	 *   </li>
	 * </ul>
	 *
	 * @param task  the task to configure
	 * @param stage the configuration stage indicator
	 */
	public static void config(ITask task, Integer stage) {
		switch (stage) {
		case 0,1:
			task.setOriginalPriority(WorkflowPriority.NORMAL);
			task.setExpiryTimestamp(Date.from(Instant.now().plus(2, ChronoUnit.MINUTES)));
			break;
		case 2:
			task.setOriginalPriority(WorkflowPriority.HIGH);
			task.setExpiryTimestamp(Date.from(Instant.now().plus(1, ChronoUnit.MINUTES)));
			
			// Alternatively, you can use the Ivy Business Calendar to calculate the expiry based on working days.
			// This line sets the task's expiry to 7 working days from now.
			// Uncomment to apply this logic:
			// task.setExpiryTimestamp(Ivy.cal().getWorkDayIn(7).toJavaDate());
			break;
		case 3:
			task.setOriginalPriority(WorkflowPriority.EXCEPTION);
			task.setExpiryTimestamp(null);
			break;
		default:
			task.setOriginalPriority(WorkflowPriority.NORMAL);
			task.setExpiryTimestamp(null);
			break;
		}
	}
}
