package no.foodelicious.service;

public class Recipe {
    private final long id;
    private final String description;
    private final String directions;

    public Recipe(long id, String description, String directions) {
        super();
        this.id = id;
        this.description = description;
        this.directions = directions;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDirections() {
        return directions;
    }
}
