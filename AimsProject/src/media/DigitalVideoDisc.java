package src.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private String director;
    private int length;

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
        this.director = director;
        this.length = length;
    }

    public DigitalVideoDisc(String title) {
        super(title, null, null, 0, 0);
        this.director = null;
        this.length = 0;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, null, 0, cost);
        this.director = null;
        this.length = 0;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, 0, cost);
        this.director = director;
        this.length = 0;
    }


    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    public String toString() {
        return "DVD - " + this.getTitle() + " - " + this.getCategory() + ": " + this.getCost() + "$";
    }
}
