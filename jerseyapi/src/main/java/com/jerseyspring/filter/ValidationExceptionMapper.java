package com.jerseyspring.filter;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

/**
 * 
 * @author sk
 *
 */
@Provider
@Component
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException>{

	@Override
	public Response toResponse(ValidationException exception) {
		 return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
	}

}
