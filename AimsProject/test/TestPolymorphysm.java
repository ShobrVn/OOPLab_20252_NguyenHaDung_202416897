package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import src.media.Media;
import src.media.CompactDisc;
import src.media.DigitalVideoDisc;
import src.media.Book;

public class TestPolymorphysm {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "Queen", 17, 9.99f);
        DigitalVideoDisc dvd = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 120, 19.99f);
        Book book = new Book("The Great Gatsby", "Fiction", 10.99f);

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);

        System.out.println("Sorted by cost, then title:");
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}