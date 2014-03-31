package no.foodelicious.core.model;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity("recipe")
public class Recipe {

	public Recipe() {
		
	}

	@JsonSerialize(using = ObjectIdSerializer.class)
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

	@JsonProperty
	@JsonDeserialize(using = CourseTypeDeserializer.class)
	@JsonSerialize(using = CourseTypeSerializer.class)
	private CourseType courseType;

	@JsonProperty
	private List<RecipeItem> recipeItems;

	@JsonProperty
	private String source;
	
	@JsonProperty
	private String imageId;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

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

	public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((courseType == null) ? 0 : courseType.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((directions == null) ? 0 : directions.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((recipeItems == null) ? 0 : recipeItems.hashCode());
		result = prime * result
				+ ((servings == null) ? 0 : servings.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recipe other = (Recipe) obj;
		if (courseType != other.courseType)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (directions == null) {
			if (other.directions != null)
				return false;
		} else if (!directions.equals(other.directions))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (recipeItems == null) {
			if (other.recipeItems != null)
				return false;
		} else if (!recipeItems.equals(other.recipeItems))
			return false;
		if (servings == null) {
			if (other.servings != null)
				return false;
		} else if (!servings.equals(other.servings))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recipe [id=" + id + ", name=" + name + ", description="
				+ description + ", directions=" + directions + ", servings="
				+ servings + ", courseType=" + courseType + ", recipeItems="
				+ recipeItems + ", source=" + source + "]";
	}
}