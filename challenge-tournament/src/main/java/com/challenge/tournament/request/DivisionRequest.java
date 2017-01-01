package com.challenge.tournament.request;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class DivisionRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String id;
	
	@NotEmpty
	private String name;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
