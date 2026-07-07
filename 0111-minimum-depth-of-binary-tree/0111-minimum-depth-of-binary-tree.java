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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        
        // If the both subtrees are empty...
        if(root.left == null && root.right == null)
            return 1;
        // If the left subtree is empty, return the depth of right subtree after adding 1 to it...
        if(root.left == null)
            return 1 + rightDepth;
        // If the right subtree is empty, return the depth of left subtree after adding 1 to it...
        if(root.right == null)
            return 1 + leftDepth;
        // When the two child function return its depth...
        // Pick the minimum out of these two subtrees and return this value after adding 1 to it...
        return 1 + Math.min(leftDepth, rightDepth);
    }
}