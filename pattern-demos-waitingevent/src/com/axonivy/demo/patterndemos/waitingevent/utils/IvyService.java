package com.axonivy.demo.patterndemos.waitingevent.utils;

import org.apache.commons.collections.CollectionUtils;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.workflow.query.IntermediateEventQuery;

public class IvyService {

	private static final IvyService INSTANCE = new IvyService();

	private IvyService() {
	}

	public static IvyService get() {
		return INSTANCE;
	}

	/**
	 * Fire an Intermediate Event by EventId.
	 *
	 * @param eventId the event identifier
	 * @return true if any event is found and fired
	 */
	public boolean fireIntermediateEventByEventId(String eventId) {

		var query = IntermediateEventQuery.create();
		query.where().eventId().isEqual(eventId);

		var ies = Ivy.wf().getIntermediateEventQueryExecutor().getResults(query);
		
		ies.forEach(ie -> 
			Ivy.wf().fireIntermediateEvent(ie.getIntermediateEventElement(), eventId, null, null)
		);

		return CollectionUtils.isNotEmpty(ies);
	}
}
