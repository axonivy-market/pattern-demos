package com.axonivy.demo.patterndemos.waitingevent.utils;

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

		var intermediateEvents = Ivy.wf().getIntermediateEventQueryExecutor().getResults(query);

		intermediateEvents.forEach(intermediateEvent -> Ivy.wf()
				.fireIntermediateEvent(intermediateEvent.getIntermediateEventElement(), eventId, null, null));

		return !intermediateEvents.isEmpty();
	}
}
