interface StreamingService {
    void streamMovie(String movie);

    default void showSubscriptionDetails() {
        System.out.println("Streaming Subscription: Premium Plan - Unlimited Movies");
    }
}

interface GamingService {
    void playGame(String game);

    default void showSubscriptionDetails() {
        System.out.println("Gaming Subscription: Pro Plan - Unlimited Games");
    }
}

class SmartTV implements StreamingService, GamingService {
    private String[] movies;
    private String[] games;

    public SmartTV(String[] movies, String[] games) {
        this.movies = movies;
        this.games = games;
    }

    public void streamMovie(String movie) {
        System.out.println("Streaming movie: " + movie);
    }

    public void playGame(String game) {
        System.out.println("Playing game: " + game);
    }

    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }

    public void displayAllContent() {
        System.out.println("Available Movies:");
        for (String m : movies) {
            System.out.println("- " + m);
        }
        System.out.println("Available Games:");
        for (String g : games) {
            System.out.println("- " + g);
        }
    }
}

public class SmartTVDemo {
    public static void main(String[] args) {
        String[] movies = {"Inception", "Interstellar", "The Matrix"};
        String[] games = {"Chess", "Fortnite", "Minecraft"};

        SmartTV tv = new SmartTV(movies, games);
        tv.showSubscriptionDetails();
        tv.displayAllContent();
        tv.streamMovie(movies[0]);
        tv.playGame(games[1]);
    }
}
