class Notification {
    String recipientName;
    String message;

    Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
    }

    void sendNotification() {
        System.out.println("Sending generic notification to " + recipientName);
    }
}

class EmailNotification extends Notification {
    EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    void sendNotification() {
        System.out.println("Email to " + recipientName + ": " + message);
    }
}

class SMSNotification extends Notification {
    SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    void sendNotification() {
        System.out.println("SMS to " + recipientName + ": " + message);
    }
}

class PushNotification extends Notification {
    PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    void sendNotification() {
        System.out.println("Push Notification to " + recipientName + ": " + message);
    }
}

public class NotificationSystemDemo {
    public static void main(String[] args) {
        Notification[] notifications = {
            new EmailNotification("Alice", "Your order has shipped."),
            new SMSNotification("Bob", "Your OTP is 4521."),
            new PushNotification("Charlie", "You have a new message.")
        };

        for (Notification n : notifications) {
            n.sendNotification();
        }
    }
}
