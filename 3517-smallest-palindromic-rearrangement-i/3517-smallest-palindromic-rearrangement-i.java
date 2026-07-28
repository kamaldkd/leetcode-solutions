class Solution {
    public String smallestPalindrome(String s) {
        String start = "";
        String mid = "";
        String end = "";

        int[] characters = new int[26];
        for(char ch : s.toCharArray()) {
            characters[ch - 'a']++;
        }

        for(int i=0; i<26;i++) {
            int freq = characters[i];
            if(freq == 0) continue;

            String letter = "" + (char) ('a' + i);
            start = start + letter.repeat(freq/2);
            mid = mid + letter.repeat(freq%2);
            end = letter.repeat(freq/2) + end;

        }

        return start + mid + end;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna