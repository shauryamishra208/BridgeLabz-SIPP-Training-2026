interface LuggageScanner {
    boolean isLuggageSafe(String luggageId);

    default void displaySecurityGuidelines() {
        System.out.println("Luggage Guidelines: No sharp objects, liquids over 100ml, or flammable items.");
    }
}

interface PassportVerifier {
    boolean isPassportValid(String passportNo);

    default void displaySecurityGuidelines() {
        System.out.println("Passport Guidelines: Passport must be valid and not expired.");
    }

    static boolean isPassportNumberValid(String passportNo) {
        return passportNo != null && passportNo.matches("[A-Z][0-9]{7}");
    }
}

class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
    public boolean isLuggageSafe(String luggageId) {
        return luggageId != null && luggageId.length() == 6;
    }

    public boolean isPassportValid(String passportNo) {
        return PassportVerifier.isPassportNumberValid(passportNo);
    }

    public void displaySecurityGuidelines() {
        LuggageScanner.super.displaySecurityGuidelines();
        PassportVerifier.super.displaySecurityGuidelines();
    }

    public void checkPassenger(String name, String luggageId, String passportNo) {
        boolean luggageOk = isLuggageSafe(luggageId);
        boolean passportOk = isPassportValid(passportNo);
        String status = (luggageOk && passportOk) ? "Allowed to Board" : "Not Allowed to Board";
        System.out.println(name + " -> " + status);
    }
}

public class AirportSecurityDemo {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie"};
        String[] luggageIds = {"LG1234", "LG12", "LG5678"};
        String[] passports = {"A1234567", "B123", "C7654321"};

        AirportSecuritySystem system = new AirportSecuritySystem();
        system.displaySecurityGuidelines();

        for (int i = 0; i < names.length; i++) {
            system.checkPassenger(names[i], luggageIds[i], passports[i]);
        }
    }
}
