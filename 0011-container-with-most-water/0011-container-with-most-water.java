class Solution {
    public int maxArea(int[] height) {
        int leftBoundary = 0, rightBoundary = height.length - 1;
        int maxArea = 0;
        while(leftBoundary < rightBoundary) {
            int min = Math.min(height[leftBoundary], height[rightBoundary]);
            maxArea = Math.max(maxArea, min * (rightBoundary-leftBoundary));

            while (leftBoundary < rightBoundary && height[leftBoundary] <= min) {
                leftBoundary++;
            }
            while (rightBoundary > leftBoundary && height[rightBoundary] <= min) {
                rightBoundary--;
            }
        }
        return maxArea;
    }
}