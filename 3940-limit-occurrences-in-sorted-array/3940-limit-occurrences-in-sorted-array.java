class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int i = 0; 
        while(i < nums.length) {
            int el = nums[i];
            int j = 0;
            while(i < nums.length && nums[i] == el && j < k) {
                list.add(el);
                i++;
                j++;
            }
            while(i < nums.length && nums[i] == el) i++;
        } 

        int[] ans = new int[list.size()];
        i = 0;
        for(int el: list) {
            ans[i] = el;
            i++;
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna