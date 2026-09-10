/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = 0;
    public int[] dfs(TreeNode node) {
        if(node == null) return new int[]{0, 0};

        if(node.left == null && node.right == null) {
            ans++;
            System.out.println(node.val);
            return new int[] {node.val, 1}; // subtreeSum, subtreeCount
        }
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int subtreeSum = left[0] + right[0] + node.val;
        int subtreeCount = left[1] + right[1] + 1;

        int avg = Math.round(subtreeSum / subtreeCount);
        if(avg == node.val) ans++;

        return new int[]{subtreeSum, subtreeCount};
    }
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna