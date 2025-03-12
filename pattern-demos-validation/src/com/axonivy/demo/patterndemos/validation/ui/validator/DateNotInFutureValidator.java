package com.axonivy.demo.patterndemos.validation.ui.validator;

import java.time.LocalDate;
import java.util.Arrays;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import ch.ivyteam.ivy.environment.Ivy;

@FacesValidator("dateNotInFutureValidator")
public class DateNotInFutureValidator implements Validator {
	public DateNotInFutureValidator() {
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		var dateValue = (LocalDate) value;
		var label = (String) component.getAttributes().get("label");
		if (!dateValue.isAfter(LocalDate.now())) {
			var errorMessage = Ivy.cms().co("/Validation/dateNotInFuture", Arrays.asList(label));
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, errorMessage));
		}
	}
}

