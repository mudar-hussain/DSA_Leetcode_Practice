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
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        return res;
        
    }
    private void dfs(TreeNode root, int level) {
        if(root == null) return;
        List<Integer> temp;
        if(level<res.size()) {
            temp = res.get(level);
            temp.add(root.val);
            res.set(level, temp);
        } else {
            temp = new ArrayList<>();
            temp.add(root.val);
            res.add(level, temp);
        }
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}