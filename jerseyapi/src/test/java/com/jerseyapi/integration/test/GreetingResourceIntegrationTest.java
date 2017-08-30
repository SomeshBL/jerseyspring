package com.jerseyapi.integration.test;

import static org.junit.Assert.assertEquals;

import java.util.logging.LogManager;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.jerseyspring.config.JerseyAppConfiguration;
import com.jerseyspring.config.SpringAppConfiguration;

/**
 * 
 * @author sk
 *
 */
public class GreetingResourceIntegrationTest extends JerseyTest{
	
	 @Override
	    public Application configure() {
	        // configure proper logging
	        LogManager.getLogManager().reset();
	        SLF4JBridgeHandler.install();

	        // configure spring context
	        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
	        context.register(SpringAppConfiguration.class);
	        context.getEnvironment().setActiveProfiles("production");
	        context.refresh();

	        // configure Jersey app
	        MockServletContext mockServletContext = new MockServletContext();
	        mockServletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, context);

	        JerseyAppConfiguration config = new JerseyAppConfiguration(mockServletContext);
	        config.property("contextConfig", context); // from SpringComponentProvider.PARAM_SPRING_CONTEXT="contextConfig"
	        return config;
	    }

	    @Test
	    public void testGetGreeting() {
	        Response response = target("greeting").queryParam("name", "somesh")
	                                              .request().get();

	        assertEquals("BL Information", response.getHeaderString("X-Powered-By"));
	        String message = response.readEntity(String.class);
	        assertEquals("Hello somesh!", message);
	        System.out.println(message);

	        response.close();
	    }

}
