class Solution {
    public Boolean isVowel(char ch) {
        ch = Character.toUpperCase(ch);
        
        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        char[] str = s.toCharArray();
        
        while(left < right) {
            if(isVowel(str[left]) && isVowel(str[right])) {
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                
                left++;
                right--;
            }
            
            if(!isVowel(str[left])) left++;
            if(!isVowel(str[right])) right--;
        }
               
        return new String(str);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna