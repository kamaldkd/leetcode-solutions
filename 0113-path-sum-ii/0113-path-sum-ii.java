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
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
    public void pathSumHelper(TreeNode root, int remaining) {
        if(root == null) return;

        path.add(root.val);
        remaining -= root.val;

        if(isLeaf(root) && remaining == 0) {
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        pathSumHelper(root.left, remaining);
        pathSumHelper(root.right, remaining);

        path.remove(path.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSumHelper(root, targetSum);
        return ans;
    }
}