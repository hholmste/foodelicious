package no.foodelicious.core.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity("recipe")
public class Recipe{
	
	@Id
	private ObjectId id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String description;	

	@JsonProperty
	private String directions;
	
	@JsonProperty
	private Integer servings;
	
	@JsonProperty( )
	private CourseType courseType;
	
	@JsonProperty
	private List<RecipeItem> recipeItems;
	
	@JsonProperty
	private String source;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDirections() {
		return directions;
	}
	
	public void setDirections(String directions) {
		this.directions = directions;
	}
	
	public Integer getServings() {
		return servings;
	}
	
	public void setServings(Integer servings) {
		this.servings = servings;
	}
	
	public CourseType getCourseType() {
		return courseType;
	}
	
	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}
	
	public List<RecipeItem> getRecipeItems() {
		return recipeItems;
	}
	
	public void setRecipeItems(List<RecipeItem> recipeItems) {
		this.recipeItems = recipeItems;
	}
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}

	public String toString(){
		return String.format("Id[name='%s', description='%s']",
                name, description);
	}
}