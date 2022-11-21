package model;

public class Podcast extends Audio {
    
    private String description;
    private TypeCategory typeCategory;

    public Podcast(String name, String url, int duration, String description, int typeCategory) {
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

    /* 
    * Description: Allows Reproducer
     */
    @Override
    public String reproducer() {
        // TODO Auto-generated method stub
        return "Playing the Podcast " + this.getName();
    }

}
