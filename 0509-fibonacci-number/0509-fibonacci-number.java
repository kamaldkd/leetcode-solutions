class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1) return n;
        
        int x = 0;
        int y = 1;
        int fib = 0;
        
        for(int i = 2; i <= n; i++) {
            fib = x + y;
            x = y;
            y = fib;
        }
        
        return fib;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna