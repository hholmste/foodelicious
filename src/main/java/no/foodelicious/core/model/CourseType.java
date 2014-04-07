package no.foodelicious.core.model;


public enum CourseType {
	DESSERT("Dessert"),
	DRINK("Drikke"),
	STARTER("Forrett"),
	PASTERY("Gjærbakst"),
	CAKE("Kake"),
	DINNER("Middag"),
	SALAD("Salat"),
	SAUCE("Saus"),
	SNACK("Smårett");
	
	private final String name;
	
	private CourseType(final String name) {
	    this.name = name;
    }
	
	public String getName(){
	    return name;
	}
}