package src;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    // backtrace auth:
    // if(goal reached)
    //      add sol to list
    // for(0 ... num of choice)
    //      if choice valid
    //          make choice
    //          back trace
    //          undo choice
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        permuteRec(result, new ArrayList<>(), nums, new boolean[nums.length]);

        return result;
    }

    private void permuteRec(List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] checked){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!checked[i]){
                checked[i] = true;
                temp.add(nums[i]);
                permuteRec(result, temp, nums, checked);
                checked[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
