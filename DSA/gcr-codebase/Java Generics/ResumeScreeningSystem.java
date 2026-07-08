import java.util.ArrayList;
import java.util.List;

public class ResumeScreeningSystem {
    static abstract class JobRole {
        private final String candidateName;

        public JobRole(String candidateName) {
            this.candidateName = candidateName;
        }

        public String getCandidateName() { return candidateName; }

        public abstract String getRoleName();

        @Override
        public String toString() {
            return candidateName + " -> " + getRoleName();
        }
    }

    static class SoftwareEngineer extends JobRole {
        public SoftwareEngineer(String name) { super(name); }
        @Override public String getRoleName() { return "Software Engineer"; }
    }

    static class DataScientist extends JobRole {
        public DataScientist(String name) { super(name); }
        @Override public String getRoleName() { return "Data Scientist"; }
    }

    static class ProductManager extends JobRole {
        public ProductManager(String name) { super(name); }
        @Override public String getRoleName() { return "Product Manager"; }
    }

    static class Resume<T extends JobRole> {
        private final List<T> candidates = new ArrayList<>();

        public void addCandidate(T candidate) {
            candidates.add(candidate);
        }

        public List<T> getCandidates() {
            return candidates;
        }
    }

    static <T extends JobRole> boolean screenResume(T candidate) {
        return candidate.getCandidateName() != null && !candidate.getCandidateName().isEmpty();
    }

    static void runScreeningPipeline(List<? extends JobRole> candidates) {
        for (JobRole candidate : candidates) {
            boolean passed = screenResume(candidate);
            System.out.println(candidate + " - Screening " + (passed ? "PASSED" : "FAILED"));
        }
    }

    public static void main(String[] args) {
        Resume<SoftwareEngineer> engineerResumes = new Resume<>();
        engineerResumes.addCandidate(new SoftwareEngineer("Alice"));
        engineerResumes.addCandidate(new SoftwareEngineer("Bob"));

        Resume<DataScientist> scientistResumes = new Resume<>();
        scientistResumes.addCandidate(new DataScientist("Charlie"));

        Resume<ProductManager> managerResumes = new Resume<>();
        managerResumes.addCandidate(new ProductManager("Dana"));

        System.out.println("Screening Software Engineers:");
        runScreeningPipeline(engineerResumes.getCandidates());

        System.out.println("Screening Data Scientists:");
        runScreeningPipeline(scientistResumes.getCandidates());

        System.out.println("Screening Product Managers:");
        runScreeningPipeline(managerResumes.getCandidates());
    }
}
