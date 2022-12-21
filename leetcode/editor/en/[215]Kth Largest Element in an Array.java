import java.util.Arrays;

/**
Given an integer array nums and an integer k, return the kᵗʰ largest element in 
the array. 

 Note that it is the kᵗʰ largest element in the sorted order, not the kᵗʰ 
distinct element. 

 You must solve it in O(n) time complexity. 

 
 Example 1: 
 Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
 
 Example 2: 
 Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 
 
 Constraints: 

 
 1 <= k <= nums.length <= 10⁵ 
 -10⁴ <= nums[i] <= 10⁴ 
 

 Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) 
Quickselect 👍 11838 👎 598

*/

/**
 * use partition of quick sort.
 *
 * don't need to sort the whole array, but sort the kth element.
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        
        while(true){

            int result = partition(nums, left, right);

            if(result < target){
                left = result + 1;
            } else if(result > target){
                right = result - 1;
            } else {
                return nums[target];
            }
        }
    }

    private int partition(int[] arr, int left, int right){
        int pivot = arr[right];
        int i = left;

        for(int j = left; j < right; j++){
            if(arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i , right);
        return i;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
