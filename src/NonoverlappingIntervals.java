package src;

import java.util.Arrays;
import java.util.Comparator;

public class NonoverlappingIntervals {
    public static void main(String[] args) {
        int[][] test = {{1,4}, {1,3}, {3, 4}, {4,6}, {4,5}, {5,6}, {2,3}};
        System.out.println(eraseOverlapIntervals(test));
    }
    public static int eraseOverlapIntervals(int[][] intervals) {
        // 435
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int prevEdge = Integer.MIN_VALUE;
        for(int[] interval: intervals){
            if(interval[0] < prevEdge){
                count+=1;
            } else {
                prevEdge = interval[1];
            }
        }
        return count;
    }
}
