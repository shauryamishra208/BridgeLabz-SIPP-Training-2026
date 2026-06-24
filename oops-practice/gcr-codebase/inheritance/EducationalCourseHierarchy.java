class Course {
    private String courseName;
    private int duration;

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public String getCourseName() { return courseName; }
    public int getDuration() { return duration; }

    public void displayInfo() {
        System.out.println("Course Name : " + courseName);
        System.out.println("Duration    : " + duration + " hours");
    }
}

class OnlineCourse extends Course {
    private String platform;
    private boolean isRecorded;

    public OnlineCourse(String courseName, int duration,
                        String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    public String getPlatform() { return platform; }
    public boolean isRecorded() { return isRecorded; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Platform    : " + platform);
        System.out.println("Recorded    : " + (isRecorded ? "Yes" : "No"));
    }
}

class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;

    public PaidOnlineCourse(String courseName, int duration,
                            String platform, boolean isRecorded,
                            double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    public double getFee() { return fee; }
    public double getDiscount() { return discount; }

    public double getDiscountedFee() {
        return fee - (fee * discount / 100);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Fee         : $%.2f%n", fee);
        System.out.printf("Discount    : %.0f%%%n", discount);
        System.out.printf("Final Price : $%.2f%n", getDiscountedFee());
    }
}

public class EducationalCourseHierarchy {
    public static void main(String[] args) {
        Course base = new Course("Introduction to Java", 20);
        OnlineCourse oc = new OnlineCourse("Data Structures", 35, "Coursera", true);
        PaidOnlineCourse pc = new PaidOnlineCourse(
            "Machine Learning", 50, "Udemy", true, 199.99, 20
        );

        System.out.println("=== Basic Course ===");
        base.displayInfo();

        System.out.println("\n=== Online Course ===");
        oc.displayInfo();

        System.out.println("\n=== Paid Online Course ===");
        pc.displayInfo();
    }
}
