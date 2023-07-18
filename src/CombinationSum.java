package src;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumRec(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void combinationSumRec(List<List<Integer>> result, List<Integer> temp,int[] candidates, int remain, int index){
        if(remain == 0){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            if(remain - candidates[i] >= 0){
                remain -= candidates[i];
                temp.add(candidates[i]);
                combinationSumRec(result, temp, candidates, remain, i);
                remain += candidates[i];
                temp.remove(temp.size() - 1);
            }
        }
    }
}
