package com.axonivy.demo.patterndemos.ui.admin;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import com.axonivy.demo.patterndemos.enums.AdminDecision;

public class AdminTaskBean {
	private String task;
	private String details;
	private Set<AdminDecision> buttons;
	private AdminDecision decision;

	public AdminTaskBean(String task, String details, Collection<AdminDecision> buttons) {
			this.task = task;
			this.details = details;
			this.buttons = buttons.stream().collect(Collectors.toSet());
		}

	/**
	 * @return the task
	 */
	public String getTask() {
		return task;
	}

	/**
	 * @param task the task to set
	 */
	public void setTask(String task) {
		this.task = task;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}

	/**
	 * @return the buttons
	 */
	public Set<AdminDecision> getButtons() {
		return buttons;
	}

	/**
	 * @param buttons the buttons to set
	 */
	public void setButtons(Set<AdminDecision> buttons) {
		this.buttons = buttons;
	}

	/**
	 * @return the decision
	 */
	public AdminDecision getDecision() {
		return decision;
	}

	/**
	 * @param decision the decision to set
	 */
	public void setDecision(AdminDecision decision) {
		this.decision = decision;
	}
	
}
