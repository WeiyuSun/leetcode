package src;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        helper(result, new ArrayList<>(), nums, 0);

        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> path, int[] nums, int index){
        result.add(new ArrayList<>(path));
        for(int i = index; i < nums.length; i++){
            path.add(nums[i]);
            helper(result, path, nums, i + 1);
            path.remove(path.size() -  1);
        }
    }
}
