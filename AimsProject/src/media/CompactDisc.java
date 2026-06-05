package src.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, String artist, int length, float cost) {
        super(title, category, artist, length, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (Track track : tracks) {
            track.play();
        }
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("The track \"" + track.getTitle() + "\" has been added to the CD.");
        } else {
            System.out.println("The track \"" + track.getTitle() + "\" is already in the CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("The track \"" + track.getTitle() + "\" has been removed from the CD.");
        } else {
            System.out.println("Cannot find the track \"" + track.getTitle() + "\" in the CD.");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public String toString() {
        return "CD - " + this.getTitle() + " - " + this.getCategory() + ": " + this.getCost() + " $";
    }
}
