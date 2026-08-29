class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        dfs(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void dfs(List<String> res, StringBuilder sb, int open, int close, int n) {
        if (sb.length() == 2 * n) {      // for n pairs, the length of the valid string will be 2 * n
            res.add(new String(sb));
            return ;
        }

        if (open < n) {
            sb.append("(");
            dfs(res, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1); // remove this open "(" while backtracking
        }
        if (close < open) {
            sb.append(")");
            dfs(res, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1); // remove this close ")" while backtracking
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna