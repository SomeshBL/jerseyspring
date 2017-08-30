package com.jerseyspring.filter;

import java.io.IOException;
import java.util.Map;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jerseyspring.service.header.HeaderService;

@Provider
@Component
public class RandomHeaderFilter implements ContainerResponseFilter {

	@Autowired
	private HeaderService headerService;

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		Map<String, String> headers = headerService.getHeaders();
		for (Map.Entry<String, String> entry : headers.entrySet()) {
			responseContext.getHeaders().putSingle(entry.getKey(), entry.getValue());
		}

	}

}
