abstract class LibraryMember {
    String memberName;
    String memberId;

    LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    abstract double calculateFine(int overdueDays);

    void printDetails() {
        System.out.println("Member: " + memberName + " | ID: " + memberId);
    }
}

class StudentMember extends LibraryMember {
    StudentMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    double calculateFine(int overdueDays) {
        return overdueDays * 1.0;
    }
}

class FacultyMember extends LibraryMember {
    FacultyMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    double calculateFine(int overdueDays) {
        return overdueDays * 0.5;
    }
}

class GuestMember extends LibraryMember {
    GuestMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    double calculateFine(int overdueDays) {
        return overdueDays * 2.0;
    }
}

public class LibraryMembershipDemo {
    static LibraryMember findById(LibraryMember[] members, String id) {
        for (LibraryMember m : members) {
            if (m.memberId.equals(id)) {
                return m;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryMember[] members = {
            new StudentMember("Alice", "S001"),
            new FacultyMember("Dr. Smith", "F001"),
            new GuestMember("Bob", "G001")
        };

        int[] overdueDays = {5, 3, 7};

        for (int i = 0; i < members.length; i++) {
            members[i].printDetails();
            System.out.println("Fine: " + members[i].calculateFine(overdueDays[i]));
        }

        LibraryMember found = findById(members, "F001");
        if (found != null) {
            System.out.println("Found Member:");
            found.printDetails();
        } else {
            System.out.println("Member not found");
        }
    }
}
