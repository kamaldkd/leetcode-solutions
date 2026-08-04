class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        // constraints given: 
        // 2 <= nums.length <= 100
        // 1 <= nums[i] <= 100

        boolean[] set = new boolean[101];
        int min = 101, max = 0;

        for(int num : nums) {
            set[num] = true;

            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = min; i <= max; i++) {
            if(!set[i]) ans.add(i);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna