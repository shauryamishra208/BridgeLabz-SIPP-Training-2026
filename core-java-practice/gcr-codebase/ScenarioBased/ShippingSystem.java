class Package {
    private final String trackingId;
    private double weight;

    public Package(String trackingId, double weight) {
        this.trackingId = trackingId;
        setWeight(weight);
    }

    public String getTrackingId() {
        return trackingId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight <= 0.0) {
            System.out.println("Error: Invalid weight (" + weight + "). Weight must be greater than 0.");
            return;
        }
        this.weight = weight;
    }
}

class ExpressPackage extends Package {
    private String priorityLevel;

    public ExpressPackage(String trackingId, double weight, String priorityLevel) {
        super(trackingId, weight);
        this.priorityLevel = priorityLevel;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void printShippingLabel() {
        System.out.println("======== SHIPPING LABEL ========");
        System.out.println("Tracking ID   : " + getTrackingId());
        System.out.println("Weight (kg)   : " + getWeight());
        System.out.println("Priority      : " + priorityLevel);
        System.out.println("=================================");
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("--- Scenario A: Valid Input ---");
        ExpressPackage exp = new ExpressPackage("EXP101", 2.5, "Critical");
        exp.printShippingLabel();

        System.out.println("\n--- Scenario B: Invalid Input ---");
        System.out.println("Attempting to set weight to -1.5:");
        exp.setWeight(-1.5);

        System.out.println("Attempting to set weight to 0.0:");
        exp.setWeight(0.0);

        System.out.println("\nWeight remains unchanged at: " + exp.getWeight());
    }
}