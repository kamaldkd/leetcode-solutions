class Solution {
    public int maximumLengthSubstring(String s) {
        int max = 0, left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int right=0; right<s.length(); right++) {
            char curr = s.charAt(right);
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            while(!map.isEmpty() && map.get(curr) > 2) {
                char c = s.charAt(left);

                map.put(c, map.get(c) - 1);

                if(map.get(c) == 0) map.remove(c);
                left++;
            }

            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna