package com.jerseyspring.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * 
 * @author sk
 *
 */
@JsonRootName("model")
public class Model {
	
	@JsonProperty("name")
	public final String name;
	
	@JsonCreator
	public Model(@JsonProperty("name")String name){
		this.name = name;
	}

}
