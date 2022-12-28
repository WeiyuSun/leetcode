import javax.print.DocFlavor;
import java.util.*;

/**
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 * <p>
 * <p>
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * <p>
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * -10⁴ <= nums[i] <= 10⁴
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * <p>
 * <p>
 * <p>
 * Follow up: Your algorithm's time complexity must be better than O(n log n),
 * where n is the array's size.
 * <p>
 * Related Topics Array Hash Table Divide and Conquer Sorting Heap (Priority
 * Queue) Bucket Sort Counting Quickselect 👍 12186 👎 448
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }
        }

        PriorityQueue<int[]> frequencyQueue = new PriorityQueue<>(new CustomComparator());
        Iterator<Map.Entry<Integer, Integer>> iterator = frequencyMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            frequencyQueue.add(new int[]{entry.getKey(), entry.getValue()});
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = frequencyQueue.poll()[0];
        }

        return result;
    }

    private class CustomComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) { // [number, frequency]
            Integer frequency1 = o1[1];
            Integer frequency2 = o2[1];

            int result = frequency1.compareTo(frequency2);

            if (result > 0)
                return -1;
            if (result < 0)
                return 1;
            return 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
