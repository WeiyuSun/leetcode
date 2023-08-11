package src;

import java.util.*;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] data = {{1, 4}, {0, 0}};
        ArrayList<int []> test = new ArrayList<>();
        test.add(new int[]{1,2});
        int[] a = test.get(0);
        a[1] = 3;
        System.out.println(Arrays.toString(test.get(0)));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        System.out.println(Arrays.deepToString(intervals));
        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            assert result.peekLast() != null;
            if (result.peekLast()[1] >= intervals[i][0]) {
                int[] temp = result.pollLast();
                temp[0] = Math.min(temp[0], intervals[i][0]);
                temp[1] = Math.max(temp[1], intervals[i][1]);
                result.add(temp);
            } else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[][]{});
    }
}
