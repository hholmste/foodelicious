package no.foodelicious.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

@Path("/recipe/{id}")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class RecipeSearchResource {
    
    private final Map<Long, Optional<Recipe>> recipes = new HashMap<>(); 
    private final Recipe defaultRecipe = new Recipe(1, "Pizza", "Kjøp grandis på rema - husk ketchup.");
    
    {
        recipes.put(1L, Optional.of(defaultRecipe));
        recipes.put(2L, Optional.of(new Recipe(2, "Burger", "McDonalds.")));
        recipes.put(3L, Optional.of(new Recipe(3, "Suppe", "Toro - kjøkkenets beste venn.")));
        recipes.put(4L, Optional.of(new Recipe(4, "Pannekaker", "Bland melk, mel, salt, egg og smeltet smør.")));
    }

    @GET
    @Timed
    public Recipe getRecipe(@PathParam("id") Long id) {
        return recipes.get(id).or(defaultRecipe);
    }
}
