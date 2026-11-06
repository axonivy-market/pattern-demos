package com.axonivy.demo.patterndemos.validation.ui.validator;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

public abstract class BaseValidatorSimple<B> implements Validator<Object> {

	private String beanId;

	public BaseValidatorSimple() {
		this("bean");
	}

	public BaseValidatorSimple(String beanId) {
		this.beanId = beanId;
	}

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if(component.getAttributes().get("isValidationDisabled") != null && Boolean.valueOf(component.getAttributes().get("isValidationDisabled").toString())) {
			return;
		}

		@SuppressWarnings("unchecked")
		var bean = (B) component.getAttributes().get(beanId);
		validate(bean, context, component, value);
	}

	protected abstract void validate(B bean, FacesContext context, UIComponent component, Object value);
}
