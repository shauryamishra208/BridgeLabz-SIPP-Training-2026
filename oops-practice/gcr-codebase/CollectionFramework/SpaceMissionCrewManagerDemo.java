import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Astronaut {
    String astronautId;
    String name;
    String specialization;

    Astronaut(String astronautId, String name, String specialization) {
        this.astronautId = astronautId;
        this.name = name;
        this.specialization = specialization;
    }

    public String toString() {
        return name + " (" + astronautId + ", " + specialization + ")";
    }
}

class SpaceMissionCrewManager {
    private Map<String, List<Astronaut>> missionCrew;
    private Map<String, Set<String>> missionAstronautIds;

    SpaceMissionCrewManager() {
        missionCrew = new HashMap<>();
        missionAstronautIds = new HashMap<>();
    }

    void addMission(String missionName) {
        missionCrew.putIfAbsent(missionName, new ArrayList<>());
        missionAstronautIds.putIfAbsent(missionName, new HashSet<>());
    }

    boolean assignAstronaut(String missionName, Astronaut astronaut) {
        addMission(missionName);
        Set<String> ids = missionAstronautIds.get(missionName);
        if (ids.contains(astronaut.astronautId)) {
            System.out.println(astronaut.name + " is already assigned to " + missionName);
            return false;
        }
        ids.add(astronaut.astronautId);
        missionCrew.get(missionName).add(astronaut);
        System.out.println(astronaut.name + " assigned to " + missionName);
        return true;
    }

    void displayMissions() {
        for (String mission : missionCrew.keySet()) {
            List<Astronaut> crew = missionCrew.get(mission);
            System.out.println("Mission: " + mission + " | Crew Size: " + crew.size());
            for (Astronaut a : crew) {
                System.out.println("- " + a);
            }
        }
    }
}

public class SpaceMissionCrewManagerDemo {
    public static void main(String[] args) {
        SpaceMissionCrewManager manager = new SpaceMissionCrewManager();

        Astronaut a1 = new Astronaut("A001", "Neil", "Pilot");
        Astronaut a2 = new Astronaut("A002", "Buzz", "Engineer");
        Astronaut a3 = new Astronaut("A003", "Sally", "Scientist");

        manager.assignAstronaut("Apollo", a1);
        manager.assignAstronaut("Apollo", a2);
        manager.assignAstronaut("Apollo", a1);
        manager.assignAstronaut("Mars Mission", a3);
        manager.assignAstronaut("Mars Mission", a1);

        manager.displayMissions();
    }
}
