package no.foodelicious.core;

import no.foodelicious.core.model.Recipe;

public class RecipeObjectMother {

	public static Recipe create() {
		Recipe recipe = new Recipe();
		recipe.setName("Grandiosa");
		recipe.setDescription("Sett på stekeovn");
		recipe.setServings(1);
		recipe.setSource("www.vg.no");
		
		return recipe;
	}
}
