import java.util.Scanner;

import src.cart.Cart;
import src.media.Book;
import src.media.CompactDisc;
import src.media.DigitalVideoDisc;
import src.media.Media;
import src.media.Playable;
import src.store.Store;

public class Aims {
    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void updateStoreMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();
        Cart cart = new Cart();
        populateStore(store);
        boolean exit = false;

        while (!exit) {
            showMenu();
            int choice = readInt(scanner);
            switch (choice) {
                case 1:
                    handleViewStore(store, cart, scanner);
                    break;
                case 2:
                    handleUpdateStore(store, scanner);
                    break;
                case 3:
                    handleCart(cart, scanner);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 0, 1, 2, or 3.");
            }
        }

        System.out.println("Exiting AIMS. Goodbye!");
        scanner.close();
    }

    private static void populateStore(Store store) {
        store.addMedia(new Book("The Hobbit", "Fantasy", 12.99f));
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", 18.99f));
        store.addMedia(new CompactDisc("Thriller", "Music", "Michael Jackson", 42, 14.99f));
    }

    private static void handleViewStore(Store store, Cart cart, Scanner scanner) {
        boolean back = false;
        while (!back) {
            store.displayStore();
            storeMenu();
            int choice = readInt(scanner);
            switch (choice) {
                case 1:
                    handleMediaDetails(store, cart, scanner);
                    break;
                case 2:
                    addMediaToCart(store, cart, scanner);
                    break;
                case 3:
                    playMediaFromStore(store, scanner);
                    break;
                case 4:
                    handleCart(cart, scanner);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 0, 1, 2, 3, or 4.");
            }
        }
    }

    private static void handleMediaDetails(Store store, Cart cart, Scanner scanner) {
        String title = readLine(scanner, "Enter the media title: ");
        Media media = store.getMediaByTitle(title);
        if (media == null) {
            System.out.println("Invalid title. Please try again.");
            return;
        }

        displayMediaDetails(media);
        boolean back = false;
        while (!back) {
            mediaDetailsMenu();
            int choice = readInt(scanner);
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    if (media instanceof DigitalVideoDisc) {
                        System.out.println("Current number of DVDs in cart: " + cart.countDigitalVideoDiscs());
                    }
                    back = true;
                    break;
                case 2:
                    playMedia(media);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 0, 1, or 2.");
            }
        }
    }

    private static void addMediaToCart(Store store, Cart cart, Scanner scanner) {
        String title = readLine(scanner, "Enter the media title: ");
        Media media = store.getMediaByTitle(title);
        if (media == null) {
            System.out.println("Invalid title. Please try again.");
            return;
        }
        cart.addMedia(media);
        if (media instanceof DigitalVideoDisc) {
            System.out.println("Current number of DVDs in cart: " + cart.countDigitalVideoDiscs());
        }
    }

    private static void playMediaFromStore(Store store, Scanner scanner) {
        String title = readLine(scanner, "Enter the media title: ");
        Media media = store.getMediaByTitle(title);
        if (media == null) {
            System.out.println("Invalid title. Please try again.");
            return;
        }
        if (media instanceof Playable) {
            playMedia(media);
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private static void handleUpdateStore(Store store, Scanner scanner) {
        boolean back = false;
        while (!back) {
            updateStoreMenu();
            int choice = readInt(scanner);
            switch (choice) {
                case 1:
                    addMediaToStore(store, scanner);
                    break;
                case 2:
                    removeMediaFromStore(store, scanner);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 0, 1, or 2.");
            }
        }
    }

    private static void addMediaToStore(Store store, Scanner scanner) {
        System.out.println("Choose media type to add:");
        System.out.println("1. Book");
        System.out.println("2. DVD");
        System.out.println("3. CD");
        System.out.println("0. Back");
        int choice = readInt(scanner);
        switch (choice) {
            case 1:
                String title = readLine(scanner, "Enter title: ");
                String category = readLine(scanner, "Enter category: ");
                float cost = readFloat(scanner, "Enter cost: ");
                store.addMedia(new Book(title, category, cost));
                break;
            case 2:
                title = readLine(scanner, "Enter title: ");
                category = readLine(scanner, "Enter category: ");
                String director = readLine(scanner, "Enter director: ");
                int length = readInt(scanner, "Enter length: ");
                cost = readFloat(scanner, "Enter cost: ");
                store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
                break;
            case 3:
                title = readLine(scanner, "Enter title: ");
                category = readLine(scanner, "Enter category: ");
                String artist = readLine(scanner, "Enter artist: ");
                cost = readFloat(scanner, "Enter cost: ");
                int cdLength = readInt(scanner, "Enter total length: ");
                store.addMedia(new CompactDisc(title, category, artist, cdLength, cost));
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid option. Please choose 0, 1, 2, or 3.");
        }
    }

    private static void removeMediaFromStore(Store store, Scanner scanner) {
        String title = readLine(scanner, "Enter the media title to remove: ");
        Media media = store.getMediaByTitle(title);
        if (media == null) {
            System.out.println("Invalid title. Please try again.");
            return;
        }
        store.removeMedia(media);
    }

    private static void handleCart(Cart cart, Scanner scanner) {
        boolean back = false;
        while (!back) {
            cart.displayCart();
            cartMenu();
            int choice = readInt(scanner);
            switch (choice) {
                case 1:
                    handleCartFilter(cart, scanner);
                    break;
                case 2:
                    handleCartSort(cart, scanner);
                    break;
                case 3:
                    removeMediaFromCart(cart, scanner);
                    break;
                case 4:
                    playMediaFromCart(cart, scanner);
                    break;
                case 5:
                    placeOrder(cart);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please choose 0, 1, 2, 3, 4, or 5.");
            }
        }
    }

    private static void handleCartFilter(Cart cart, Scanner scanner) {
        System.out.println("Filter by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.println("0. Back");
        int choice = readInt(scanner);
        switch (choice) {
            case 1:
                int id = readInt(scanner, "Enter media ID: ");
                cart.searchById(id);
                break;
            case 2:
                String title = readLine(scanner, "Enter media title: ");
                cart.searchByTitle(title);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid option. Please choose 0, 1, or 2.");
        }
    }

    private static void handleCartSort(Cart cart, Scanner scanner) {
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        System.out.println("0. Back");
        int choice = readInt(scanner);
        switch (choice) {
            case 1:
                cart.sortByTitle();
                cart.displayCart();
                break;
            case 2:
                cart.sortByCost();
                cart.displayCart();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid option. Please choose 0, 1, or 2.");
        }
    }

    private static void removeMediaFromCart(Cart cart, Scanner scanner) {
        String title = readLine(scanner, "Enter the media title to remove: ");
        Media media = cart.getMediaByTitle(title);
        if (media == null) {
            System.out.println("Invalid title. Please try again.");
            return;
        }
        cart.removeMedia(media);
    }

    private static void playMediaFromCart(Cart cart, Scanner scanner) {
        String title = readLine(scanner, "Enter the media title: ");
        Media media = cart.getMediaByTitle(title);
        if (media == null) {
            System.out.println("Invalid title. Please try again.");
            return;
        }
        if (media instanceof Playable) {
            playMedia(media);
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private static void placeOrder(Cart cart) {
        if (cart.getAmountOrdered() == 0) {
            System.out.println("Your cart is empty. Add items before placing an order.");
            return;
        }
        System.out.println("Order created. Thank you for your purchase!");
        cart.clearCart();
    }

    private static void displayMediaDetails(Media media) {
        System.out.println("------------------MEDIA DETAILS------------------");
        System.out.println("Title: " + media.getTitle());
        System.out.println("Category: " + media.getCategory());
        System.out.println("Cost: " + media.getCost() + " $");
        if (media instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) media;
            System.out.println("Director: " + dvd.getDirector());
            System.out.println("Length: " + dvd.getLength());
        } else if (media instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc) media;
            System.out.println("Artist: " + cd.getArtist());
            System.out.println("Length: " + cd.getLength());
        }
        System.out.println("--------------------------------------------------");
    }

    private static void playMedia(Media media) {
        ((Playable) media).play();
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return readInt(scanner);
    }

    private static float readFloat(Scanner scanner, String prompt) {
        System.out.print(prompt);
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Float.parseFloat(line);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

    private static String readLine(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
}
