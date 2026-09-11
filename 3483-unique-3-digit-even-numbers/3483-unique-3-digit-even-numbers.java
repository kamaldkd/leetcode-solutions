class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) freq[d]++;

        int count = 0;

        for (int h = 1; h <= 9; h++) {
            if (freq[h] == 0) continue;
            freq[h]--;

            for (int t = 0; t <= 9; t++) {
                if (freq[t] == 0) continue;
                freq[t]--;

                for (int u = 0; u <= 8; u += 2) {
                    if (freq[u] > 0) count++;
                }

                freq[t]++;
            }

            freq[h]++;
        }

        return count;
        
        // HashSet<Integer> set = new HashSet<>();
            
            // for(int i = 0; i < digits.length; i++) {
            //     if(digits[i] == 0) continue;
            //     for(int j = 0; j < digits.length; j++) {
            //         if(j == i) continue;
            //         for(int k = 0; k < digits.length; k++) {
            //             if(k == j || k == i) continue;
            //             int num = (digits[i]*100) + (digits[j]*10) + (digits[k]);
            //             if(num % 2 == 0) set.add(num);
            //         }
            //     }
            // }
            // return set.size();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna