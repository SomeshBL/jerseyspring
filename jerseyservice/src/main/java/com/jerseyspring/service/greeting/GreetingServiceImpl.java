package com.jerseyspring.service.greeting;


import org.springframework.stereotype.Service;

/**
 * 
 * @author sk
 *
 */
@Service
public class GreetingServiceImpl implements GreetingService {
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getGreeting(String name) {
		return "Hello "+name + "!";
	}

	

}
