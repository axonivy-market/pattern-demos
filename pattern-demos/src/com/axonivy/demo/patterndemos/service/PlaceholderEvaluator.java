package com.axonivy.demo.patterndemos.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.axonivy.demo.patterndemos.enums.Placeholder;

/**
 * Class for evaluating placeholders and replacing them with values.
 * 
 **/
public abstract class PlaceholderEvaluator<T extends Placeholder> {
	// Set missingPh collecting all placeholders, which hasn't got value.
	protected Set<T> missingPh = new HashSet<>();
	// Map phCache storing evalvuated values, to save computing, if we have more same placeholders.
	protected Map<T, String> phCache = new HashMap<>();
	public abstract String evaluate(T ph);
	public abstract Class<T> getType();

	/**
	 * Method for evaluating placeholders and replacing them with values.
	 * 
	 * @param T placeholder
	 **/
	public String evaluateWithCaching(T ph) {
		String result = null;
		if (ph != null) {
			// firstly we look in cache
			String value = phCache.get(ph);
			// if value is null and placeholder is between missing, we now, that we can skip it
			if (value == null && !missingPh.contains(ph)) {
				// look in SalutationPlaceholder.evaluate
				value = evaluate(ph);
				// if value is empty, we can add placeholder between missing placeholders 
				if (StringUtils.isBlank(value)) {
					missingPh.add(ph);
					value = "";
				}
				phCache.put(ph, value);
			}
			if(value != null) {
				result = value;
			}
		}
		return result;
	}
}

