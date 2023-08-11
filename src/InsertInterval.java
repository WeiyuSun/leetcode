package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        //System.out.println(Arrays.deepToString(insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 57
        if(intervals.length == 0){
            return new int[][]{newInterval};
        }
        for(int[] token: intervals){
            if(token[0] < newInterval[0] && token[1] > newInterval[1]){
                return intervals;
            }

            if((token[0] >= newInterval[0] && token[0] <= newInterval[1]) ||
                    token[1] >= newInterval[0] && token[1] <= newInterval[1]){
                newInterval[0] = Math.min(token[0], newInterval[0]);
                newInterval[1] = Math.max(token[1], newInterval[1]);
            }
        }

        List<int[]> result = new ArrayList<>();

        boolean added = false;
        int prevMax = -1;
        for(int[] token: intervals){
            if(token[0] >= newInterval[0] && token[1] <= newInterval[1]){
                if(added)
                    continue;
                result.add(newInterval);
                added = true;
                prevMax = newInterval[1];
            } else {
                if(prevMax < newInterval[0] && token[0] > newInterval[1]){
                    result.add(newInterval);
                    added = true;
                }
                result.add(token);
                prevMax = token[1];
            }
        }

        if(added == false){
            result.add(newInterval);
        }

        return result.toArray(new int[][]{});
    }
}
