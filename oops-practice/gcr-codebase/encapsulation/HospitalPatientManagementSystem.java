abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public abstract double calculateBill();

    public void displayPatientDetails() {
        System.out.println("----------------------------------");
        System.out.println("Patient ID    : " + patientId);
        System.out.println("Name          : " + name);
        System.out.println("Age           : " + age);
        System.out.println("Patient Type  : " + getClass().getSimpleName());
        System.out.println("Total Bill    : ₹" + calculateBill());
        System.out.println("----------------------------------");
    }
}

class InPatient extends Patient {
    private double roomCharges;
    private double treatmentCharges;
    private int daysAdmitted;

    public InPatient(String patientId, String name, int age,
                     double roomCharges, double treatmentCharges, int daysAdmitted) {
        super(patientId, name, age);
        this.roomCharges = roomCharges;
        this.treatmentCharges = treatmentCharges;
        this.daysAdmitted = daysAdmitted;
    }

    public double getRoomCharges() { return roomCharges; }
    public void setRoomCharges(double roomCharges) { this.roomCharges = roomCharges; }
    public double getTreatmentCharges() { return treatmentCharges; }
    public void setTreatmentCharges(double treatmentCharges) { this.treatmentCharges = treatmentCharges; }
    public int getDaysAdmitted() { return daysAdmitted; }
    public void setDaysAdmitted(int daysAdmitted) { this.daysAdmitted = daysAdmitted; }

    @Override
    public double calculateBill() {
        return (roomCharges * daysAdmitted) + treatmentCharges;
    }
}

class OutPatient extends Patient {
    private double consultationFees;
    private double treatmentCharges;

    public OutPatient(String patientId, String name, int age,
                      double consultationFees, double treatmentCharges) {
        super(patientId, name, age);
        this.consultationFees = consultationFees;
        this.treatmentCharges = treatmentCharges;
    }

    public double getConsultationFees() { return consultationFees; }
    public void setConsultationFees(double consultationFees) { this.consultationFees = consultationFees; }
    public double getTreatmentCharges() { return treatmentCharges; }
    public void setTreatmentCharges(double treatmentCharges) { this.treatmentCharges = treatmentCharges; }

    @Override
    public double calculateBill() {
        return consultationFees + treatmentCharges;
    }
}

public class HospitalPatientManagementSystem {
    public static void main(String[] args) {
        InPatient inPatient = new InPatient("P001", "Suresh Verma", 45,
                                            2500, 15000, 4);
        OutPatient outPatient = new OutPatient("P002", "Meena Joshi", 32,
                                               800, 3500);

        System.out.println("===== Hospital Patient Management System =====");
        inPatient.displayPatientDetails();
        outPatient.displayPatientDetails();
    }
}
