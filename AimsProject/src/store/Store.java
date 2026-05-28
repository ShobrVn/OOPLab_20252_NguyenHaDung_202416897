package AimsProject.src.store;

import AimsProject.src.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore;

    public Store() {
        itemsInStore = new DigitalVideoDisc[100];
    }

    public void addDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < itemsInStore.length; i++) {
            if (itemsInStore[i] == null) {
                itemsInStore[i] = dvd;
                System.out.println("The disc \"" + dvd.getTitle() + "\" has been added to the store.");
                break;
            }
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < itemsInStore.length; i++) {
            if (itemsInStore[i] == dvd) {
                found = true;
                itemsInStore[i] = null;
                System.out.println("The disc \"" + dvd.getTitle() + "\" has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("Cannot find the disc \"" + dvd.getTitle() + "\" in the store.");
        }
    }

    public void displayStore() {
        System.out.println("***********************STORE***********************");
        for (int i = 0; i < itemsInStore.length; i++) {
            if (itemsInStore[i] != null) {
                System.out.println((i + 1) + ". " + itemsInStore[i].toString());
            }
        }
        System.out.println("************************************************");
    }
}
