class Solution {
    public int myAtoi(String s) {
        String s2 = s.trim();
        if (s2.isEmpty()) return 0; // Add this early

        int result = 0;
        int index = 0;
        boolean isNegative = false;

        if (index < s2.length() && s2.charAt(index) == '-') {
            isNegative = true;
            index++;
        } else if (index < s2.length() && s2.charAt(index) == '+') {
            isNegative = false;
            index++;
        }

        for (; index < s2.length(); index++) {
            if (s2.charAt(index) < 48 || s2.charAt(index) > 57)
                break;

            int digit = s2.charAt(index) - '0';
            
            if (isNegative ? -result < Integer.MIN_VALUE / 10 : result > Integer.MAX_VALUE / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else if (result == Integer.MAX_VALUE / 10) {
                if (isNegative ? digit > 8 : digit > 7) {
                    return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            }
            System.out.println("Final result: " + result);
            result = result * 10 + digit;
            System.out.println("Final result: " + result);
        }
        
        return isNegative ? -result : result;
    }
}