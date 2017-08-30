package com.jerseyspring.api.model;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.jerseyspring.json.Model;

/**
 * 
 * @author sk
 *
 */
@Service
public class ModelResourceImpl implements ModelResource{

	@Override
	public Response getResponse() {
		Model model = new Model("Somesh Kumar");
        return Response.ok(model).build();
	}

}
