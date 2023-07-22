package src;

// 11
public class ContainerWithMostWater {
     public int maxArea(int[] height) {
          int left = 0;
          int right = height.length -1;
          int max = -1;
          int curr;

          while(left < right) {
               curr = Math.min(height[left], height[right]) * (right - left);
               max = Math.max(curr, max);
               if(height[left] > height[right]){
                    right--;
               } else {
                    left++;
               }
          }

          return max;
     }
}
