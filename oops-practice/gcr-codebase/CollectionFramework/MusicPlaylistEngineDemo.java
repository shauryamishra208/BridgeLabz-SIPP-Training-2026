import java.util.LinkedList;

class MusicPlaylistEngine {
    private LinkedList<String> recentlyPlayed;
    private static final int MAX_SIZE = 10;

    MusicPlaylistEngine() {
        recentlyPlayed = new LinkedList<>();
    }

    void playSong(String song) {
        recentlyPlayed.addFirst(song);
        if (recentlyPlayed.size() > MAX_SIZE) {
            recentlyPlayed.removeLast();
        }
        System.out.println("Now playing: " + song);
    }

    boolean search(String song) {
        return recentlyPlayed.contains(song);
    }

    void displayHistory() {
        System.out.println("Recently Played:");
        for (String song : recentlyPlayed) {
            System.out.println(song);
        }
    }
}

public class MusicPlaylistEngineDemo {
    public static void main(String[] args) {
        MusicPlaylistEngine engine = new MusicPlaylistEngine();
        String[] songs = {
            "Shape of You", "Blinding Lights", "Levitating", "Bad Guy", "Believer",
            "Perfect", "Counting Stars", "Faded", "Roar", "Thunder", "Sunflower", "Memories"
        };

        for (String song : songs) {
            engine.playSong(song);
        }

        System.out.println("Is 'Shape of You' in history? " + engine.search("Shape of You"));
        System.out.println("Is 'Memories' in history? " + engine.search("Memories"));

        engine.displayHistory();
    }
}
