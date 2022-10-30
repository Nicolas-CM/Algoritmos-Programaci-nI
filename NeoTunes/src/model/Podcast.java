package model;

import java.time.LocalTime;

public class Podcast extends Audio {
    
    private String description;
    private TypeCategory typeCategory;

    public Podcast(String name, String url, LocalTime duration, String description, int typeCategory) {
        super(name, url, duration);
        this.description = description;
        this.typeCategory = TypeCategory.values()[typeCategory];
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeCategory getTypeCategory() {
        return typeCategory;
    }

    public void setTypeCategory(TypeCategory typeCategory) {
        this.typeCategory = typeCategory;
    }

}
