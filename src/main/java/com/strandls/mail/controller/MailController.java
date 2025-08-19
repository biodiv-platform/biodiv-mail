/**
 *
 */
package com.strandls.mail.controller;

import com.strandls.mail.ApiConstants;
import com.strandls.mail.util.TemplateUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

/**
 * @author Abhishek Rudra
 *
 */

@Tag(name = "Mail Service", description = "Operations related to the mail system")
@Path(ApiConstants.V1 + ApiConstants.SERIVCE)
public class MailController {

	@Inject
	private TemplateUtil t;

	@GET
	@Path(ApiConstants.PING)
	@Produces(MediaType.TEXT_PLAIN)
	@Operation(summary = "Health check", description = "Returns PONG if service is up")
	public Response ping() {
		t.getTemplateAsString("observation.ftlh", null);
		return Response.status(Status.OK).entity("PONG").build();
	}
}
