class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int index = 0;
        int n = s.length();
        int sign = 1;
        int total = 0;

        // 1. Skip leading whitespaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // 2. Check for optional sign character
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // 3. Convert valid digit characters and check bounds
        while (index < n) {
            char currChar = s.charAt(index);
            
            // Break early at the first non-digit character
            if (currChar < '0' || currChar > '9') {
                break;
            }

            int digit = currChar - '0';

            // 4. Handle rounding/overflow conditions
            if (total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;
        }

        return total * sign;
    }
}