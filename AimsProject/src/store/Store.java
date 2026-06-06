package src.store;

import src.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore;

    public Store() {
        itemsInStore = new ArrayList<>();
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("The media \"" + media.getTitle() + "\" has been added to the store.");
    }

    public void removeMedia(Media media) {
        boolean found = false;
        for (int i = 0; i < itemsInStore.size(); i++) {
            if (itemsInStore.get(i) == media) {
                found = true;
                itemsInStore.remove(i);
                System.out.println("The media \"" + media.getTitle() + "\" has been removed from the store.");
                break;
            }
        }
        if (!found) {
            System.out.println("Cannot find the media \"" + media.getTitle() + "\" in the store.");
        }
    }

    public void displayStore() {
        System.out.println("***********************STORE***********************");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("************************************************");
    }

    public Media getMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.isMatch(title)) {
                return media;
            }
        }
        return null;
    }

    public Media getMediaById(int id) {
        for (Media media : itemsInStore) {
            if (media.getId() == id) {
                return media;
            }
        }
        return null;
    }
}
