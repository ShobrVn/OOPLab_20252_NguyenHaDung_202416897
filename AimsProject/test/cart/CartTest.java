package test.cart;

import src.disc.DigitalVideoDisc;
import src.cart.Cart;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        cart.addDigitalVideoDisc(dvd2);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        // Test the print method
        cart.print();
        // Test the SearchByID method
        System.out.println("Search for ID 1: ");
        cart.searchById(1);
        System.out.println("Search for ID 5: ");
        cart.searchById(5);

        // Test the searchByTitle method
        System.out.println("Search for 'Star': ");
        cart.searchByTitle("Star");
        System.out.println("Search for 'Aladdin': ");
        cart.searchByTitle("Aladdin");
        System.out.println("Search for 'Batman': ");
        cart.searchByTitle("Batman");
    }
}
