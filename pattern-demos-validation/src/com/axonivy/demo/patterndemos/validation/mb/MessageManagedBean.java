package com.axonivy.demo.patterndemos.validation.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;

import ch.ivyteam.ivy.environment.Ivy;

@ManagedBean(name = "messageBean")
public class MessageManagedBean {

	private static final MessageManagedBean INSTANCE = new MessageManagedBean();

	/**
	 * Get service instance.
	 *
	 * @return Instance of the class
	 */
	public static MessageManagedBean get() {
		return INSTANCE;
	}

	/**
	 * Get message for required field.
	 *
	 * @param cmsOrText if starting with a slash, then the text is interpreted as a CMS path
	 * @return
	 */
	public String getRequiredMessage(String cmsOrText) {
		return getLabelMessage("/Validation/isRequired", cmsOrText);
	}

	/**
	 * Get message with a label prefix.
	 *
	 * Gets any message from the CMS and expects one paramater which is the label of a widget.
	 *
	 * @param validatorCms
	 * @param cmsOrText
	 * @return
	 */
	public String getLabelMessage(String validatorCms, String cmsOrText) {
		return Ivy.cms().co(validatorCms, List.of(getCmsOrText(cmsOrText)));
	}

	private String getCmsOrText(String text) {
		return text != null && text.charAt(0) == '/' ? Ivy.cms().co(text) : text;
	}
}
