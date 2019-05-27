package com.acme;

import java.security.Timestamp;
import java.util.Date;

public class Pet {

	private String name;
	private String kind;
	private Date dateOfBirth;
	private boolean fixed;
	
	
	/*
	    @GenAsPersistable(superclass = Object.class, interfaces = { ContentHolder.class , Ownable.class } ,
	        properties = {
			@GeneratedProperty(name="name", type=String.class,
			    columnProperties = @ColumnProperties(index=true),
			    constraints = @PropertyConstraints(required = true, upperLimit=60)),
		    @GeneratedProperty(name="kind", type = PetKind.class,
					 constraints = @PropertyConstraints(upperLimit=40)),
			@GeneratedProperty(name="dateOfBirth", time = Timestamp.class),
			@GeneratedProperty(name="fixed", type=boolean.class)
	} 
	)
	    */
	    
	public static Pet newPet() {
		
		final Pet instance = new Pet();
		
		
		return instance;
	}
	
	    public void setName(String name) {
	    	
	    	this.name = name;
	    }
        public void setFixed(boolean fixed) {
	    	
	    	this.fixed = fixed;
	    }
        public void setKind(String kind) {
	    	
	    	this.kind = kind;
	    }
        public void setDateOfBirth(Date date) {
 	
 	       this.dateOfBirth = date;
        }
}














