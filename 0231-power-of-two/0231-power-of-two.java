class Solution {
    public boolean isPowerOfTwo(int n) {
        
//         while(n != 0) {
//             if(n == 1) return true;
            
//             if(n % 2 != 0) {
//                 return false;
//             }
            
//             n = n / 2;
//         }
        
//         return false;
        
        return (n > 0) && (n & n-1) == 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna