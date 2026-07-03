class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while(left < right) {
            int min = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, min * (right-left));

            while (left < right && height[left] <= min) {
                left++;
            }
            while (right > left && height[right] <= min) {
                right--;
            }
        }
        return maxArea;
    }
}