class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        
        Map<String, Integer> seen = new HashMap<>();
        
        int [] prev = cells;
        
        int day = 0;
        
        while(day < n) {
            
            String state = Arrays.toString(prev);
            
            if(seen.containsKey(state)) {
                int cycleLength = day - seen.get(state);
                int remaining = n - day;
                int skip = remaining / cycleLength;
                
                day += skip * cycleLength;
                
                if(day == n) break;
            }
            seen.put(state, day);
            
            int [] next = new int[8];
            
            // calculate next day
            for(int i = 1; i < 7; i++) { // i= 0 to 7
                if(prev[i - 1] == prev[i + 1]) {
                    next[i] = 1;
                }
            }
            prev = next;
            
            day++;
        }
        
        return prev;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna