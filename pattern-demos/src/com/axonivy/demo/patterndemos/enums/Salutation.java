package com.axonivy.demo.patterndemos.enums;

import com.axonivy.demo.patterndemos.service.DocumentService;
import com.axonivy.utils.persistence.enums.HasCmsName;

public enum Salutation  implements HasCmsName {
	FORMAL_FEMALE,
	FORMAL_MALE,
	INFORMAL,
	FORMAL;

	/**
	 * Replace placeholders by values in salutation from person.
	 * 
	 * @param String content
	 * @param String title
	 * @param String firstName
	 * @param String lastName
	 * @param String title2
	 * @return string
	 */
	public static String fillDataInSalutation(String content, String title, String firstName, String lastName, String title2) {
		String replaced = DocumentService.get().replacePlaceholders(content, new SalutationPlaceholderEvaluator(title, firstName, lastName, title2));

		return replaced.trim().replaceAll(" +", " ");
	}

	/**
	 * Return the format entry of the instance.
	 *
	 * @return
	 */
	public String getCmsFormat() {
		return getCms("format");
	}
}
