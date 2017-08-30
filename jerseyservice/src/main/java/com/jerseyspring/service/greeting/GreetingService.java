package com.jerseyspring.service.greeting;

/**
 * 
 * @author sk
 *
 */
public interface GreetingService {
	
	/**
	 * Return greeting with name
	 * @param name
	 * @return String
	 */
	String getGreeting(String name);

}
