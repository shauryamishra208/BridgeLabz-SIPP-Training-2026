interface TextModeration {
    boolean isOffensive(String post);

    default void displayModerationPolicy() {
        System.out.println("Text Moderation Policy: No offensive or abusive language allowed.");
    }
}

interface SpamDetection {
    boolean isSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Spam Detection Policy: Repeated promotional content is not allowed.");
    }

    static boolean containsRestrictedWords(String post) {
        String[] restricted = {"buyNow", "freeMoney", "clickHere", "stupid", "idiot"};
        for (String word : restricted) {
            if (post.toLowerCase().contains(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}

class ContentModerator implements TextModeration, SpamDetection {
    public boolean isOffensive(String post) {
        return SpamDetection.containsRestrictedWords(post)
                && (post.toLowerCase().contains("stupid") || post.toLowerCase().contains("idiot"));
    }

    public boolean isSpam(String post) {
        return SpamDetection.containsRestrictedWords(post)
                && !(post.toLowerCase().contains("stupid") || post.toLowerCase().contains("idiot"));
    }

    public void displayModerationPolicy() {
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }

    public void moderate(String post) {
        if (isOffensive(post)) {
            System.out.println("\"" + post + "\" -> Offensive Post");
        } else if (isSpam(post)) {
            System.out.println("\"" + post + "\" -> Spam Post");
        } else {
            System.out.println("\"" + post + "\" -> Valid Post");
        }
    }
}

public class ContentModeratorDemo {
    public static void main(String[] args) {
        String[] posts = {
            "Check out our new product, buyNow for free money!",
            "You are such a stupid person",
            "Had a great day at the park today",
            "clickHere to win a prize idiot"
        };

        ContentModerator moderator = new ContentModerator();
        moderator.displayModerationPolicy();

        for (String post : posts) {
            moderator.moderate(post);
        }
    }
}
