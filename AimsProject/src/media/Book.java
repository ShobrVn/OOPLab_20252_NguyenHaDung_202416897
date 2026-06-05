package src.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
    
    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String author) {
        if (!authors.contains(author)) {
            authors.add(author);
            System.out.println("The author \"" + author + "\" has been added to the book.");
        }
        else {
            System.out.println("The author \"" + author + "\" is already in the book.");
        }
    }

    public void removeAuthor(String author) {
        if (authors.contains(author)) {
            authors.remove(author);
            System.out.println("The author \"" + author + "\" has been removed from the book.");
        } else {
            System.out.println("Cannot find the author \"" + author + "\" in the book.");
        }
    }

    @Override
    public String toString() {
        return "Book - " + this.getTitle() + " - " + this.getCategory() + ": " + this.getCost() + " $";
    }
}
