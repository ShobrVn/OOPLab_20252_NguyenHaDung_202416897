package test.store;

import src.disc.DigitalVideoDisc;
import src.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        store.addDVD(dvd2);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);
        store.addDVD(dvd3);

        // Display the store
        store.displayStore();

        // Test the removeDVD method
        store.removeDVD(dvd2);
        store.removeDVD(dvd2); // Try to remove the same DVD again
        store.displayStore();
    }
}
