import java.util.*;

public class InsertionSort {

    static class AthleteScore {
        String name;
        int score;

        AthleteScore(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return name + " - " + score;
        }
    }

    static class SortResult {
        int[] sortedArray;
        int shiftCount;
        boolean isBestCase;

        SortResult(int[] sortedArray, int shiftCount, boolean isBestCase) {
            this.sortedArray = sortedArray;
            this.shiftCount = shiftCount;
            this.isBestCase = isBestCase;
        }
    }

    static SortResult insertionSort(int[] arr) {
        int[] a = arr.clone();
        int n = a.length;
        int shiftCount = 0;
        boolean isBestCase = true;

        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            boolean moved = false;
            while (j >= 0 && a[j] < key) {
                a[j + 1] = a[j];
                j--;
                shiftCount++;
                moved = true;
            }
            a[j + 1] = key;
            if (moved) {
                isBestCase = false;
            }
        }

        return new SortResult(a, shiftCount, isBestCase);
    }

    static List<AthleteScore> top3Medalists(List<AthleteScore> athletes) {
        athletes.sort((a, b) -> Integer.compare(b.score, a.score));
        return athletes.subList(0, Math.min(3, athletes.size()));
    }

    public static void main(String[] args) {
        Random rand = new Random(42);
        int[] scores = new int[50];
        List<AthleteScore> athletes = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            scores[i] = rand.nextInt(101);
            athletes.add(new AthleteScore("Athlete_" + (i + 1), scores[i]));
        }

        System.out.println("=== Insertion Sort on 50 athlete scores ===");
        SortResult result = insertionSort(scores);
        System.out.println("Total shifts: " + result.shiftCount);
        System.out.println("Already sorted (best case)? " + result.isBestCase);

        System.out.println("\n=== Top 3 Medalists ===");
        String[] medals = {"Gold", "Silver", "Bronze"};
        for (int i = 0; i < top3Medalists(athletes).size(); i++) {
            AthleteScore athlete = top3Medalists(athletes).get(i);
            System.out.println(medals[i] + ": " + athlete);
        }
    }
}
