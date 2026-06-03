package src.media;

public abstract class Media {
    protected int id;
    protected String title;
    protected String category;
    protected float cost;
    private static int nbMedia = 0;

    public Media(String title, String category, float cost) {
        this.id = nbMedia++;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }
}
