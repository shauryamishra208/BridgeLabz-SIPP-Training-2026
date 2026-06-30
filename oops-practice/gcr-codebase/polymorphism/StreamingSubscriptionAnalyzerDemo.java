abstract class Subscription {
    String subscriberName;
    String subscriptionId;

    Subscription(String subscriberName, String subscriptionId) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
    }

    abstract double calculateMonthlyCharge();
}

class BasicPlan extends Subscription {
    BasicPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    double calculateMonthlyCharge() {
        return 199;
    }
}

class PremiumPlan extends Subscription {
    PremiumPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    double calculateMonthlyCharge() {
        return 499;
    }
}

class FamilyPlan extends Subscription {
    FamilyPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    double calculateMonthlyCharge() {
        return 799;
    }
}

public class StreamingSubscriptionAnalyzerDemo {
    static Subscription searchById(Subscription[] subs, String id) {
        for (Subscription s : subs) {
            if (s.subscriptionId.equals(id)) {
                return s;
            }
        }
        return null;
    }

    static void displayByPrefix(Subscription[] subs, char letter) {
        for (Subscription s : subs) {
            if (s.subscriberName.length() > 0 && Character.toUpperCase(s.subscriberName.charAt(0)) == Character.toUpperCase(letter)) {
                System.out.println(s.subscriberName + " (" + s.subscriptionId + ")");
            }
        }
    }

    static double calculateTotalRevenue(Subscription[] subs) {
        double total = 0;
        for (Subscription s : subs) {
            total += s.calculateMonthlyCharge();
        }
        return total;
    }

    public static void main(String[] args) {
        Subscription[] subs = {
            new BasicPlan("Alice", "SUB001"),
            new PremiumPlan("Bob", "SUB002"),
            new FamilyPlan("Anna", "SUB003"),
            new BasicPlan("Adam", "SUB004")
        };

        for (Subscription s : subs) {
            System.out.println(s.subscriberName + " (" + s.subscriptionId + ") Charge: " + s.calculateMonthlyCharge());
        }

        Subscription found = searchById(subs, "SUB002");
        if (found != null) {
            System.out.println("Found: " + found.subscriberName);
        }

        System.out.println("Subscribers starting with 'A':");
        displayByPrefix(subs, 'A');

        System.out.println("Total Monthly Revenue: " + calculateTotalRevenue(subs));

        Subscription mostExpensive = subs[0];
        for (Subscription s : subs) {
            if (s.calculateMonthlyCharge() > mostExpensive.calculateMonthlyCharge()) {
                mostExpensive = s;
            }
        }
        System.out.println("Most Expensive Subscription: " + mostExpensive.subscriberName + " - " + mostExpensive.calculateMonthlyCharge());
    }
}
