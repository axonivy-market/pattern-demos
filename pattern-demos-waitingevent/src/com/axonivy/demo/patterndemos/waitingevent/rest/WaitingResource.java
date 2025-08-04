package com.axonivy.demo.patterndemos.waitingevent.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.axonivy.demo.patterndemos.waitingevent.utils.IvyService;

/**
 * REST service for handling "waiting" events in the system.
 * 
 * This class exposes an endpoint under the base path "/waiting" that allows
 * external systems or users to trigger (fire) a waiting event based on a
 * specific event ID.
 */

@Path("waiting")
public class WaitingResource {

	/**
	 * Fire an intermediate event based on the given event ID.
	 * 
	 * This endpoint can be used to resume a process or workflow that is waiting for
	 * the specified event to occur.
	 *
	 * @param eventId the ID of the event to be fired
	 */

	@GET
	@Path("/fire/{eventId}")
	public void fireWaitingEvent(@PathParam("eventId") String eventId) {
		IvyService.get().fireIntermediateEventByEventId(eventId);
	}
}