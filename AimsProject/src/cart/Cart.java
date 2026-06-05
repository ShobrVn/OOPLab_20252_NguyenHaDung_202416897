package src.cart;

import src.media.DigitalVideoDisc;
import src.media.Media;
import java.util.ArrayList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private int amountOrdered = 0;

    public void addMedia(Media media) {
        if (amountOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full.");
        }
        else {
            itemsOrdered.add(media);
            amountOrdered++;
            System.out.println("The media \"" + media.getTitle() + "\" has been added.");
            if (amountOrdered == MAX_NUMBERS_ORDERED - 1) {
                System.out.println("The cart is almost full.");
            }
        }
    }

    public void removeMedia(Media media) {
        boolean found = false;
        for (int i = 0; i < amountOrdered; i++) {
            if (itemsOrdered.get(i) == media) {
                found = true;
                itemsOrdered.remove(i);
                amountOrdered--;
                System.out.println("The media \"" + media.getTitle() + "\" has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("Cannot find the media \"" + media.getTitle() + "\" in the cart.");
        }
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < amountOrdered; i++) {
            total += itemsOrdered.get(i).getCost();
        }
        return total;
    }

    public void displayCart() {
        System.out.println("***********************CART***********************");
        for (int i = 0; i < amountOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < amountOrdered; i++) {
            if (itemsOrdered.get(i).getId() == id) {
                System.out.println("Found Media: " + itemsOrdered.get(i).toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No Media found with ID: " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < amountOrdered; i++) {
            if (itemsOrdered.get(i).isMatch(title)) {
                System.out.println("Found Media: " + itemsOrdered.get(i).toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No Media found with title: " + title);
        }
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title.");
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost.");
    }

    public Media getMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                return media;
            }
        }
        return null;
    }

    public Media getMediaById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }

    public int countDigitalVideoDiscs() {
        int count = 0;
        for (Media media : itemsOrdered) {
            if (media instanceof DigitalVideoDisc) {
                count++;
            }
        }
        return count;
    }

    public void clearCart() {
        itemsOrdered.clear();
        amountOrdered = 0;
    }
}