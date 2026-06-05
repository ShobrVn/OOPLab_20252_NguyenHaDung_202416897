package src.media;

public class Disc extends Media {
    private String director;
    private int length;

    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    
    @Override
    public String toString() {
        return "Disc - " + this.getTitle() + " - " + this.getCategory() + ": " + this.getCost() + " $";
    }
}
