package com.axonivy.demo.patterndemos.validation;

import java.util.AbstractMap;
import java.util.Set;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import ch.ivyteam.ivy.environment.Ivy;

/**
 * Constants for use in project and xhtml pages.  
 */
@Named(value = "constants")
@ApplicationScoped
public class Constants extends AbstractMap<String, String>{
	public static final String DATE_PLACEHOLDER = "dd.MM.yyyy";
	public static final String DATE_PATTERN = "dd.MM.yyyy";
	public static final String DATE_YEAR_RANGE = "1920:2050";
	public static final int SMALL_SIZE = 20;

	@Override
	public String get(Object key) {
		var result = "";
		try {
			var field = getClass().getDeclaredField((String)key);
			var object = field.get(this);
			if(object != null) {
				result = object.toString();
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			Ivy.log().error("Could not find constant ''{0}''", key);
		}
		return result;
	}

	@Override
	public Set<Entry<String, String>> entrySet() {
		return null;
	}
}
