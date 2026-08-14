class Solution {
    public int backtrack(int[] freq) {
        int count = 0;
        
        for(int i = 0; i < 26; i++) {
            if(freq[i] == 0) continue;
            
            // Choose this letter
            freq[i]--;
            // Current sequence is a valid non empty sequene
            count++;
            
            // Try adding more letters
            count += backtrack(freq);
            
            // Unod the choice
            freq[i]++;
        }
        
        return count;
    }
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        
        for(char ch : tiles.toCharArray()) freq[ch - 'A']++;
            
        return backtrack(freq);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna