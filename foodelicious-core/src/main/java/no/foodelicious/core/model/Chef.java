package no.foodelicious.core.model;

import java.io.Serializable;

public class Chef implements Serializable {
	
	private static final long serialVersionUID = -5298015361700164121L;

    private Integer id;
 
    private String firstname;
 
    private String lastname;
 
    private String email;
 
    private Integer telephone;
    
    private String username;
    
    private String password;
    
    private Role role;

}
