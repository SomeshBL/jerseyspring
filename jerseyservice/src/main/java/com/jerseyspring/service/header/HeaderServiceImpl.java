package com.jerseyspring.service.header;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * 
 * @author sk
 *
 */
@Service
@Profile("production")
public class HeaderServiceImpl implements HeaderService {

	@Override
	public Map<String, String> getHeaders() {
		Map<String, String> headers = new HashMap<>();
		headers.put("X-Powered-By", "BL Information");
		return headers;
	}

}
