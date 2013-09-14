package no.foodelicious.core.model;

import java.io.Serializable;
import java.util.List;

public class Recipe implements Serializable{
	
	private static final long serialVersionUID = 3727273164631210273L;

    private Integer id;
	
	private String name;
	
	private String description;
	
	private String directions;
	
	private Integer servings;
	
	private CourseType courseType;
	
	private List<RecipeItem> recipeItems;
	
	private String source;
	
}