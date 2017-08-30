package com.jerseyspring.config;

import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Context;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jerseyspring.api.greeting.GreetingResource;
import com.jerseyspring.api.model.ModelResource;
import com.jerseyspring.filter.RandomHeaderFilter;
import com.jerseyspring.filter.ValidationExceptionMapper;
import com.jerseyspring.json.ObjectMapperContextResolver;

/**
 * 
 * @author sk
 *
 */
@ApplicationPath("/rest")
public class JerseyAppConfiguration extends ResourceConfig{
	
	public JerseyAppConfiguration(@Context ServletContext context){
		WebApplicationContext appCtx = WebApplicationContextUtils.getWebApplicationContext(context);
		
		register(appCtx.getBean(GreetingResource.class));
		register(appCtx.getBean(ModelResource.class));
		
		register(appCtx.getBean(ObjectMapperContextResolver.class));
		register(appCtx.getBean(RandomHeaderFilter.class));
		register(appCtx.getBean(ValidationExceptionMapper.class));
		
		
		
	}

}
