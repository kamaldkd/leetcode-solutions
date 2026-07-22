class Solution {
    public String minWindow(String s, String t) {
        
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()) return new String();

        int start = 0, minLen = Integer.MAX_VALUE, left = 0;
        int required = 0, formed = 0;

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        required = need.size();

        for(int right=0; right<s.length(); right++){
            char ch = s.charAt(right);

            if(need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);

                if(need.get(ch).equals(window.get(ch))) formed++;
            }

            while(formed == required) {
                if(right-left+1 < minLen) {
                    minLen = right-left+1;
                    start = left;
                }
                char leftChar = s.charAt(left);

                if(need.containsKey(leftChar)) {
                    window.put(leftChar, window.get(leftChar)-1);
                    if(window.get(leftChar) < need.get(leftChar)) formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? new String() : s.substring(start, start + minLen);
    }
}