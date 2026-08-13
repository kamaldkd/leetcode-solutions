class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        boolean first = false;
        boolean second = false;
        
        int i = 0;
        while(i < bits.length) {
            if(bits[i] == 1) {
                first = false;
                second = true;
                
                i += 2;
            } else {
                first = true;
                second = false;
                
                i += 1;
            }
        }
        
        return first;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna