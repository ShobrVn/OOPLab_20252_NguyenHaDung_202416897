package src.media.comparator;

import java.util.Comparator;
import src.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        if (m1.getCost() != m2.getCost()) {
            return Float.compare(m1.getCost(), m2.getCost());
        } else {
            return m1.getTitle().compareToIgnoreCase(m2.getTitle());
        }
    }
}
