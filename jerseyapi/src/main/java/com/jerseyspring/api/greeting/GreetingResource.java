package com.jerseyspring.api.greeting;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.validation.annotation.Validated;

/**
 * 
 * @author sk
 *
 */
@Path("/greeting")
@Validated
public interface GreetingResource {
	
	@GET
	Response getGreeting(@QueryParam("name") @NotNull String name);
	
	

}
