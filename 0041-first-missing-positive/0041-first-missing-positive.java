class Solution {
    public int firstMissingPositive(int[] nums) {

        int i = 0;
        int n = nums.length;

        while (i < n) {

            // Correct index where nums[i] should be
            int correctIndex = nums[i] - 1;

            // Place the current element at its correct position
            if (nums[i] > 0 &&
                nums[i] <= n &&
                nums[i] != nums[correctIndex]) {

                swap(nums, i, correctIndex);

            } else {
                i++;
            }
        }

        // Find the first missing positive
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}