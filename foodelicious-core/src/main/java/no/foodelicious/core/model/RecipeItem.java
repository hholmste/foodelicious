package no.foodelicious.core.model;


public class RecipeItem{
		
	private Ingredient ingredient;
	
	private MeasuringUnit measuringUnit;
	
	private Integer number;
	
	public Ingredient getIngredient() {
		return ingredient;
	}
	
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	
	public MeasuringUnit getMeasuringUnit() {
		return measuringUnit;
	}
	
	public void setMeasuringUnit(MeasuringUnit measuringUnit) {
		this.measuringUnit = measuringUnit;
	}
	
	public Integer getNumber() {
		return number;
	}
	
	public void setNumber(Integer number) {
		this.number = number;
	}
}