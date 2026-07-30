class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        
        // int ans = 0;

        // for (int i = 0; i < n; i++) {
        //     ans += i / 8 + 1;
        // }

        // return ans; 
        
        return Math.min(n, 8)
     + Math.max(0, Math.min(n - 8, 8)) * 2
     + Math.max(0, Math.min(n - 16, 8)) * 3
     + Math.max(0, n - 24) * 4;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna