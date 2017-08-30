package com.jerseyspring.config;

import java.util.logging.LogManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class SpringWebContainerInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		LogManager.getLogManager().reset();
		SLF4JBridgeHandler.install();

		registerContextLoaderListener(servletContext);
		// Set the Jersey used property to it won't load a ContextLoaderListener
		servletContext.setInitParameter("contextConfigLocation", "");
	}

	private void registerContextLoaderListener(ServletContext servletContext) {
		WebApplicationContext webContext = createWebAplicationContext(SpringAppConfiguration.class);
		servletContext.addListener(new ContextLoaderListener(webContext));
		
	}

	public WebApplicationContext createWebAplicationContext(@SuppressWarnings("rawtypes") Class configClasses) {
		AnnotationConfigWebApplicationContext context =  new AnnotationConfigWebApplicationContext();
		context.getEnvironment().setActiveProfiles("production");
		context.register(configClasses);
		return context;
	}
}