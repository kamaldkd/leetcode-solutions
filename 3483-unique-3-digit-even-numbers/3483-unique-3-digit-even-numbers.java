class Solution {
    public int totalNumbers(int[] digits) {
            HashSet<Integer> set = new HashSet<>();
            
            for(int i = 0; i < digits.length; i++) {
                if(digits[i] == 0) continue;
                for(int j = 0; j < digits.length; j++) {
                    if(j == i) continue;
                    for(int k = 0; k < digits.length; k++) {
                        if(k == j || k == i) continue;
                        int num = (digits[i]*100) + (digits[j]*10) + (digits[k]);
                        if(num % 2 == 0) set.add(num);
                    }
                }
            }
            return set.size();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna