package src.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id;
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
        this.id = nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = nbDigitalVideoDiscs++;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        this.id = nbDigitalVideoDiscs++;
    }

    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
    }

    public boolean isMatch(String title) {
        if (title == null || this.title == null) {
            return false;
        }
        String[] keywords = title.toLowerCase().split("\\s+");
        String lowerTitle = this.title.toLowerCase();
        for (String keyword : keywords) {
            if (!keyword.isEmpty() && lowerTitle.contains(keyword)) {
                return true;
            }
        }
        return false;
    }
}
