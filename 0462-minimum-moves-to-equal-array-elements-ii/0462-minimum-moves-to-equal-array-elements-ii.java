class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int idx = nums.length / 2;
        int mid = nums[idx];

        if(nums.length % 2 == 0) {
            mid = (nums[idx] + nums[idx-1]) / 2;
        }

        int ans = 0;
        for(int num : nums) {
            ans += Math.abs(mid - num);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna