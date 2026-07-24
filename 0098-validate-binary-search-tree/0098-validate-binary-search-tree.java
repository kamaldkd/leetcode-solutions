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
    public boolean validateBST(TreeNode root, long min, long max) {
        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;

        return validateBST(root.left, min, root.val) && validateBST(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        return validateBST(root, min, max);
    }
}