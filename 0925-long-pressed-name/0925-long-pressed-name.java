class Solution {
    public boolean isLongPressedName(String name, String typed) {
        
        if(typed.length() < name.length()) return false;
        int i = 0;
        int j = 0;
        
        while(i < name.length()) {
            char ch = name.charAt(i);
            int nameCount = 0;
            while(i < name.length() && name.charAt(i) == ch) {
                nameCount++;
                i++;
            }
            int typedCount = 0;
            while(j < typed.length() && typed.charAt(j) == ch) {
                typedCount++;
                j++;
            }
            
            if(typedCount < nameCount) return false;
        }
        
        return j == typed.length();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna