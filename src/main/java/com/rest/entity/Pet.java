package com.rest.entity;

import java.util.Set;

public class Pet extends NamedEntity{

	private String birthDate;
	
	private OwnerEntity owner;
	
	private Set<Visit> visits;
	
	private PetType petType;
}
