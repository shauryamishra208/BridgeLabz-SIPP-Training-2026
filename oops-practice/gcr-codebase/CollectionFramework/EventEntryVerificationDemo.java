import java.util.HashSet;

class EventEntryVerificationSystem {
    private HashSet<String> registeredEmails;

    EventEntryVerificationSystem() {
        registeredEmails = new HashSet<>();
    }

    boolean register(String email) {
        if (registeredEmails.contains(email)) {
            System.out.println("Duplicate registration rejected for: " + email);
            return false;
        }
        registeredEmails.add(email);
        System.out.println("Registered successfully: " + email);
        return true;
    }

    void displayAllParticipants() {
        System.out.println("Registered Participants:");
        for (String email : registeredEmails) {
            System.out.println(email);
        }
        System.out.println("Total attendees: " + registeredEmails.size());
    }
}

public class EventEntryVerificationDemo {
    public static void main(String[] args) {
        EventEntryVerificationSystem system = new EventEntryVerificationSystem();
        system.register("alice@mail.com");
        system.register("bob@mail.com");
        system.register("alice@mail.com");
        system.register("charlie@mail.com");

        system.displayAllParticipants();
    }
}
