class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int copy = n;

        while(copy != 0) {
            int digit = copy % 10;
            copy /= 10;

            sum += digit;
            product *= digit;
        }

        return n % (sum + product) == 0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna