import java.util.*;

public class BubbleSort {

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

    static class BubbleSortResult {
        int[] sortedArray;
        int swapCount;
        boolean isBestCase;

        BubbleSortResult(int[] sortedArray, int swapCount, boolean isBestCase) {
            this.sortedArray = sortedArray;
            this.swapCount = swapCount;
            this.isBestCase = isBestCase;
        }
    }

    static BubbleSortResult bubbleSort(int[] arr) {
        int[] a = arr.clone();
        int n = a.length;
        int swapCount = 0;
        boolean isBestCase = true;

        for (int i = 0; i < n - 1; i++) {
            boolean swappedThisPass = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapCount++;
                    swappedThisPass = true;
                    if (i == 0) {
                        isBestCase = false;
                    }
                }
            }
            if (!swappedThisPass) {
                break;
            }
        }

        return new BubbleSortResult(a, swapCount, isBestCase);
    }

    static void traceBubbleSort(int[] arr) {
        int[] a = arr.clone();
        int n = a.length;
        System.out.println("Initial array: " + Arrays.toString(a));

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("After pass " + (i + 1) + ": " + Arrays.toString(a));
            if (!swapped) {
                System.out.println("No swaps in this pass -> array is sorted, stopping early.");
                break;
            }
        }
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

        System.out.println("=== Bubble Sort on 50 athlete scores ===");
        BubbleSortResult result = bubbleSort(scores);
        System.out.println("Total swaps: " + result.swapCount);
        System.out.println("Already sorted (best case)? " + result.isBestCase);

        System.out.println("\n=== Top 3 Medalists ===");
        String[] medals = {"Gold", "Silver", "Bronze"};
        for (int i = 0; i < top3Medalists(athletes).size(); i++) {
            AthleteScore athlete = top3Medalists(athletes).get(i);
            System.out.println(medals[i] + ": " + athlete);
        }

        System.out.println("\n=== Pass-by-pass Bubble Sort trace on [64, 25, 12, 22, 11] ===");
        traceBubbleSort(new int[]{64, 25, 12, 22, 11});
    }
}
