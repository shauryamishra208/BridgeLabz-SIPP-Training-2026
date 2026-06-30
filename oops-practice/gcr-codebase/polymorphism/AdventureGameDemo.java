abstract class GameCharacter {
    String characterName;

    GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    abstract void performAttack();
}

class Warrior extends GameCharacter {
    Warrior(String characterName) {
        super(characterName);
    }

    void performAttack() {
        System.out.println(characterName + " (Warrior) swings a sword for melee damage.");
    }
}

class Mage extends GameCharacter {
    Mage(String characterName) {
        super(characterName);
    }

    void performAttack() {
        System.out.println(characterName + " (Mage) casts a fireball spell.");
    }
}

class Archer extends GameCharacter {
    Archer(String characterName) {
        super(characterName);
    }

    void performAttack() {
        System.out.println(characterName + " (Archer) shoots an arrow from a distance.");
    }
}

public class AdventureGameDemo {
    static void startBattle(GameCharacter[] characters) {
        for (GameCharacter c : characters) {
            c.performAttack();
        }
    }

    public static void main(String[] args) {
        GameCharacter[] characters = {
            new Warrior("Conan"),
            new Mage("Merlin"),
            new Archer("Legolas"),
            new Warrior("Conrad"),
            new Mage("Gandalf")
        };

        startBattle(characters);

        int warriorCount = 0;
        int mageCount = 0;
        int archerCount = 0;

        for (GameCharacter c : characters) {
            if (c instanceof Warrior) {
                warriorCount++;
            } else if (c instanceof Mage) {
                mageCount++;
            } else if (c instanceof Archer) {
                archerCount++;
            }
        }

        System.out.println("Warriors: " + warriorCount);
        System.out.println("Mages: " + mageCount);
        System.out.println("Archers: " + archerCount);
    }
}
