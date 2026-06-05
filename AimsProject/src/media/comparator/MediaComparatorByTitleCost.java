package src.media.comparator;

import java.util.Comparator;
import src.media.Media;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        if (m1.getTitle().compareToIgnoreCase(m2.getTitle()) != 0) {
            return m1.getTitle().compareToIgnoreCase(m2.getTitle());
        } else {
            return Float.compare(m1.getCost(), m2.getCost());
        }
    }
}