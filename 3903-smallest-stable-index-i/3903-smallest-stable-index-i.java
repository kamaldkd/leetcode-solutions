class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] minimum = new int[n];
        minimum[n - 1] = nums[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            minimum[i] = Math.min(nums[i], minimum[i + 1]);
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            
            if(max - minimum[i] <= k) return i;
        }

        return -1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna