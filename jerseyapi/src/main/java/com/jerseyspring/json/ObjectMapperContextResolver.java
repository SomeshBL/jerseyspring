package com.jerseyspring.json;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author sk
 *
 */
@Provider
@Component
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper>{
	
	private final ObjectMapper mapper;
	
	@Autowired
    public ObjectMapperContextResolver(ObjectMapper mapper) {
    	this.mapper = mapper;
	}

	@Override
	public ObjectMapper getContext(Class<?> type) {
		return mapper;
	}

}
