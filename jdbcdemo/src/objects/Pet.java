package objects;

import java.security.Timestamp;
import java.util.Date;

public class Pet {

	private String name;
	private String kind;
	private String dateOfBirth;
	private int fixed;
	
	
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
	    // setters
	    public void setName(String name) {
	    	
	    	this.name = name;
	    }
        public void setFixed(int fixed) {
	    	
	    	this.fixed = fixed;
	    }
        public void setKind(String kind) {
	    	
	    	this.kind = kind;
	    }
        public void setDateOfBirth(String date) {
 	
 	       this.dateOfBirth = date;
        }
        
        // getters 
        public String getName() {
	    	
	    	return name;
	    }
        public int getFixed() {
	    	
	    	return fixed;
	    }
        public String getKind() {
	    	
	    	return kind;
	    }
        public String getDateOfBirth() {
 	
 	       return dateOfBirth;
        }
}














