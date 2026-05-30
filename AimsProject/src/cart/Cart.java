package src.cart;

import src.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int amountOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (amountOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full.");
        }
        else {
            itemsOrdered[amountOrdered] = disc;
            amountOrdered++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
            if (amountOrdered == MAX_NUMBERS_ORDERED - 1) {
                System.out.println("The cart is almost full.");
            }
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            addDigitalVideoDisc(disc);
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < amountOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;
                for (int j = i; j < amountOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[amountOrdered - 1] = null;
                amountOrdered--;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("Cannot find the disc \"" + disc.getTitle() + "\" in the cart.");
        }
    }

    public int getAmountOrdered() {
        return amountOrdered;
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < amountOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void displayCart() {
        for (int i = 0; i < amountOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost());
    }

    public void print() {
        System.out.println("***********************CART***********************");
        displayCart();
        System.out.println("************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < amountOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found DVD: " + itemsOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID: " + id);
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < amountOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Found DVD: " + itemsOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title: " + title);
        }
    }
}