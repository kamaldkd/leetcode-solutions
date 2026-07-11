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
    public void postorder(TreeNode root, ArrayList<Integer> arr) {
        // If the current node is NULL
        // (base case for recursion), return
        if (root == null) {
            return;
        }
        // Recursively traverse
        // the left subtree
        postorder(root.left, arr);
        // Recursively traverse 
        // the right subtree
        postorder(root.right, arr);
        // Push the current node's
        // value into the list
        arr.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        postorder(root, arr);
        
        return arr;
    }
}