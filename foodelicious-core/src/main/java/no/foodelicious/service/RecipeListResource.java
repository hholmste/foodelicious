package no.foodelicious.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.yammer.metrics.annotation.Timed;

@Path("/recipe")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class RecipeListResource {
    
    private final Map<Long, Recipe> recipes = new HashMap<>(); 
    private final Recipe defaultRecipe = new Recipe(1, "Pizza", "Kjøp grandis på rema - husk ketchup.");
    
    {
        recipes.put(1L, defaultRecipe);
        recipes.put(2L, new Recipe(2, "Burger", "McDonalds."));
        recipes.put(3L, new Recipe(3, "Suppe", "Toro - kjøkkenets beste venn."));
        recipes.put(4L, new Recipe(4, "Pannekaker", "Bland melk, mel, salt, egg og smeltet smør."));
    }

    @GET
    @Timed
    public Collection<Recipe> getRecipe() {
        return recipes.values();
    }
}
