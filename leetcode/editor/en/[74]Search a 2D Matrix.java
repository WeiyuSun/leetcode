/**
 * Write an efficient algorithm that searches for a value target in an m x n
 * integer matrix matrix. This matrix has the following properties:
 * <p>
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous
 * row.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10⁴ <= matrix[i][j], target <= 10⁴
 * <p>
 * <p>
 * Related Topics Array Binary Search Matrix 👍 9588 👎 303
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
            return false;

        int matrixL = 0;
        int matrixR = matrix.length - 1;
        int matrixM;
        int[] array;
        while (matrixL < matrixR) {
            matrixM = matrixL + (matrixR - matrixL) / 2;
            array = matrix[matrixM];

            if (array[array.length - 1] >= target) {
                matrixR = matrixM;
            } else {
                matrixL = matrixM + 1;
            }
        }

        array = matrix[matrixL];

        int l = 0;
        int r = array.length - 1;
        int mid;

        while (l <= r) {
            mid = l + (r - l) / 2;

            if (array[mid] > target) {
                r = mid - 1;
            } else if (array[mid] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
