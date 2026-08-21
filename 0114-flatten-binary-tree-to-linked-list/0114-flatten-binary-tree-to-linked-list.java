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
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        dfs(root);    
        
    }
    private TreeNode dfs(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        TreeNode rightTail = dfs(root.right);
        TreeNode leftTail = null;
        if(root.left != null) {
            leftTail = dfs(root.left);
            leftTail.right = root.right;
            root.right = root.left;
        }
        root.left = null;
        return rightTail!=null?rightTail:leftTail;
    }
}