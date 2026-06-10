package test;

import src.cart.Cart;
import src.media.Book;
import src.media.CompactDisc;
import src.media.DigitalVideoDisc;
import src.screen.CartScreen;

public class TestCartScreen {
    public static void main(String[] args) {
        Cart cart = new Cart();

        // Add several items to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);
        cart.addMedia(dvd3);

        Book book = new Book("The Great Gatsby", "Fiction", 15.5f);
        cart.addMedia(book);

        CompactDisc cd = new CompactDisc("Thriller", "Pop", "Michael Jackson", 42, 12.0f);
        cart.addMedia(cd);

        // Launch the Cart Screen
        new CartScreen(cart);
    }
}
