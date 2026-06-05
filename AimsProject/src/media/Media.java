package src.media;

import java.util.Comparator;
import src.media.comparator.MediaComparatorByCostTitle;
import src.media.comparator.MediaComparatorByTitleCost;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    private static int nbMedia = 0;

    public static final Comparator<Media>
        COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media>
        COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

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

    public abstract String toString();

    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Media other = (Media) obj;
        return title.equalsIgnoreCase(other.title);
    }
}
