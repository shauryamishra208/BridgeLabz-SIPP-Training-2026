import java.util.ArrayList;
import java.util.List;

public class SubsetsGenerator {

    static List<List<Integer>> generateSubsets(int[] nums, int index) {
        if (index == 0) {
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base;
        }

        List<List<Integer>> prevSubsets = generateSubsets(nums, index - 1);

        List<List<Integer>> allSubsets = new ArrayList<>(prevSubsets);

        for (List<Integer> subset : prevSubsets) {
            List<Integer> newSubset = new ArrayList<>(subset);
            newSubset.add(nums[index - 1]);
            allSubsets.add(newSubset);
        }

        return allSubsets;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        List<List<Integer>> subsets = generateSubsets(nums, nums.length);

        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
