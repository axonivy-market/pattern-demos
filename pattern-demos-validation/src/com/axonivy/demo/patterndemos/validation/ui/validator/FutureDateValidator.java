package com.axonivy.demo.patterndemos.validation.ui.validator;

import java.time.LocalDate;
import java.util.List;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.html.HtmlInputText;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import ch.ivyteam.ivy.environment.Ivy;
import jakarta.enterprise.context.ApplicationScoped;

@FacesValidator(value = "futureDateValidator", managed = true)
@ApplicationScoped
public class FutureDateValidator implements Validator<Object> {
	public FutureDateValidator() {
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		var dateValue = (LocalDate) value;

		var label = component instanceof HtmlInputText hit ? hit.getLabel() : component.getAttributes().get("label");

		if (!dateValue.isAfter(LocalDate.now())) {
			var errorMessage = Ivy.cms().co("/Validation/dateNotInFuture", List.of(label));
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, errorMessage));
		}
	}
}

