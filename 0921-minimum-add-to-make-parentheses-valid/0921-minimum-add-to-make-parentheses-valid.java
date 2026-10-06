class Solution {
    public int minAddToMakeValid(String s) {
        int counter = 0;
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                st.push('(');
            } else {
                if(st.isEmpty()) counter++;
                else st.pop();
            }
        }

        return counter + st.size();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna