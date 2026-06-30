abstract class RescueTeam {
    String teamId;
    String location;

    RescueTeam(String teamId, String location) {
        this.teamId = teamId;
        this.location = location;
    }

    abstract void performDuty();
}

class MedicalTeam extends RescueTeam {
    MedicalTeam(String teamId, String location) {
        super(teamId, location);
    }

    void performDuty() {
        System.out.println(teamId + " (MedicalTeam) at " + location + " is providing medical aid.");
    }
}

class FireRescueTeam extends RescueTeam {
    FireRescueTeam(String teamId, String location) {
        super(teamId, location);
    }

    void performDuty() {
        System.out.println(teamId + " (FireRescueTeam) at " + location + " is extinguishing fires.");
    }
}

class FoodSupplyTeam extends RescueTeam {
    FoodSupplyTeam(String teamId, String location) {
        super(teamId, location);
    }

    void performDuty() {
        System.out.println(teamId + " (FoodSupplyTeam) at " + location + " is distributing food supplies.");
    }
}

public class DisasterRescueManagementDemo {
    static RescueTeam findTeamByLocation(RescueTeam[] teams, String location) {
        for (RescueTeam t : teams) {
            if (t.location.equals(location)) {
                return t;
            }
        }
        return null;
    }

    static void displayTeamsByPrefix(RescueTeam[] teams, String prefix) {
        for (RescueTeam t : teams) {
            if (t.teamId.startsWith(prefix)) {
                System.out.println(t.teamId + " at " + t.location);
            }
        }
    }

    public static void main(String[] args) {
        RescueTeam[] teams = {
            new MedicalTeam("MED01", "Zone A"),
            new FireRescueTeam("FIRE01", "Zone B"),
            new FoodSupplyTeam("FOOD01", "Zone C"),
            new MedicalTeam("MED02", "Zone D"),
            new MedicalTeam("MED03", "Zone E")
        };

        for (RescueTeam t : teams) {
            t.performDuty();
        }

        RescueTeam found = findTeamByLocation(teams, "Zone B");
        if (found != null) {
            System.out.println("Team found at Zone B: " + found.teamId);
        }

        System.out.println("Teams with prefix 'MED':");
        displayTeamsByPrefix(teams, "MED");

        int medicalCount = 0;
        int fireCount = 0;
        int foodCount = 0;

        for (RescueTeam t : teams) {
            if (t instanceof MedicalTeam) {
                medicalCount++;
            } else if (t instanceof FireRescueTeam) {
                fireCount++;
            } else if (t instanceof FoodSupplyTeam) {
                foodCount++;
            }
        }

        System.out.println("Medical Teams: " + medicalCount);
        System.out.println("Fire Rescue Teams: " + fireCount);
        System.out.println("Food Supply Teams: " + foodCount);

        String maxCategory = "MedicalTeam";
        int maxCount = medicalCount;
        if (fireCount > maxCount) {
            maxCategory = "FireRescueTeam";
            maxCount = fireCount;
        }
        if (foodCount > maxCount) {
            maxCategory = "FoodSupplyTeam";
            maxCount = foodCount;
        }
        System.out.println("Category with maximum deployments: " + maxCategory + " (" + maxCount + ")");
    }
}
