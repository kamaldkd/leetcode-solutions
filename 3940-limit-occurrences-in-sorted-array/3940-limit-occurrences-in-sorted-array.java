class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length;
        int j = 1;    
        int count = 1;  

        for(int i = 1; i < n; i++){
            if(nums[i] == nums[i - 1]){
                count++;     
            } 
            else {
                count = 1;    
            }

            if(count <= k){
                nums[j] = nums[i];  
                j++;
            }
        }
        int[] ans = new int[j];
        for(int i = 0; i < j; i++){
            ans[i] = nums[i];
        }
        
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna