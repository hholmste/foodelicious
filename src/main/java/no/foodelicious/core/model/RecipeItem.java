package no.foodelicious.core.model;

public class RecipeItem {

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((ingredient == null) ? 0 : ingredient.hashCode());
		result = prime * result
				+ ((measuringUnit == null) ? 0 : measuringUnit.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		RecipeItem other = (RecipeItem) obj;
		if (ingredient == null) {
			if (other.ingredient != null)
				return false;
		} else if (!ingredient.equals(other.ingredient))
			return false;
		if (measuringUnit != other.measuringUnit)
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RecipeItem [ingredient=" + ingredient + ", measuringUnit="
				+ measuringUnit + ", number=" + number + "]";
	}
}