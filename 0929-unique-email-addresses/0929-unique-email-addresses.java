import java.util.*;

class Solution {
    public String formatName(String name) {
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<name.length(); i++) {
            char ch = name.charAt(i);
            
            if(ch == '+') break;
            if(ch == '.') continue;
            
            sb.append(ch);
        }
        
        return sb.toString();
    }
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(String s : emails) {
            String[] email = s.split("@"); 
            String name = email[0];
            String domain = email[1];
            
            name = formatName(name);
            
            set.add(name + "@" + domain);
        }
        
        return set.size();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna