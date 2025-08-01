package com.axonivy.demo.patterndemos.waitingevent.utils;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import ch.ivyteam.ivy.environment.Ivy;
import ch.ivyteam.ivy.workflow.IIntermediateEvent;
import ch.ivyteam.ivy.workflow.query.IntermediateEventQuery;

public class IvyUtils {
	
	/**
	 * Fire an Intermediate Event by EventId
	 *
	 * @param eventId the event identifier.
	 * @return true if any event is found and fired.
	 */
	public static boolean fireIntermediateEventByEventId(String eventId) {

		IntermediateEventQuery query = IntermediateEventQuery.create();
		query.where().eventId().isEqual(eventId);

		List<IIntermediateEvent> ies = Ivy.wf().getIntermediateEventQueryExecutor().getResults(query);
		for (IIntermediateEvent iIntermediateEvent : ies) {
			Ivy.wf().fireIntermediateEvent(iIntermediateEvent.getIntermediateEventElement(), eventId, null, null);
		}
		
		return CollectionUtils.isNotEmpty(ies);
	}
}
