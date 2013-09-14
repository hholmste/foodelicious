package no.foodelicious.core.model;

import java.io.Serializable;

public class RecipeItem implements Serializable{
	
	private static final long serialVersionUID = -8830990149590115981L;
	
    private Integer id;
	
	private Ingredient ingredient;
	
	private MeasuringUnit measuringUnit;
	
	private Integer number;
	
}