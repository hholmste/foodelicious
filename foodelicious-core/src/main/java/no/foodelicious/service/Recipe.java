package no.foodelicious.service;

public class Recipe {
    private long id;
    private String description;
    private String directions;
    
    
    public Recipe(long id) {
        super();
        this.id = id;
    }

    public Recipe() {
    }

    public Recipe(long id, String description, String directions) {
        super();
        this.id = id;
        this.setDescription(description);
        this.setDirections(directions);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
