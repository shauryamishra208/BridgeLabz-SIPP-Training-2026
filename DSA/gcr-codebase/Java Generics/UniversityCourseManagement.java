import java.util.ArrayList;
import java.util.List;

public class UniversityCourseManagement {
    static abstract class CourseType {
        private final String courseName;

        public CourseType(String courseName) {
            this.courseName = courseName;
        }

        public String getCourseName() { return courseName; }

        public abstract String getEvaluationMethod();

        @Override
        public String toString() {
            return courseName + " (" + getEvaluationMethod() + ")";
        }
    }

    static class ExamCourse extends CourseType {
        public ExamCourse(String name) { super(name); }
        @Override public String getEvaluationMethod() { return "Exam-Based"; }
    }

    static class AssignmentCourse extends CourseType {
        public AssignmentCourse(String name) { super(name); }
        @Override public String getEvaluationMethod() { return "Assignment-Based"; }
    }

    static class ResearchCourse extends CourseType {
        public ResearchCourse(String name) { super(name); }
        @Override public String getEvaluationMethod() { return "Research-Based"; }
    }

    static class Course<T extends CourseType> {
        private final List<T> offerings = new ArrayList<>();

        public void addCourse(T course) {
            offerings.add(course);
        }

        public List<T> getOfferings() {
            return offerings;
        }
    }

    static void listCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(" - " + course);
        }
    }

    public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Data Structures"));
        examCourses.addCourse(new ExamCourse("Operating Systems"));

        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("Web Development"));

        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("AI Research Seminar"));

        System.out.println("Exam-Based Courses:");
        listCourses(examCourses.getOfferings());

        System.out.println("Assignment-Based Courses:");
        listCourses(assignmentCourses.getOfferings());

        System.out.println("Research-Based Courses:");
        listCourses(researchCourses.getOfferings());
    }
}
