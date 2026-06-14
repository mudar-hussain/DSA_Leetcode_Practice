/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res= new ArrayList<>();
        preorder2(root, res);
        return res;
        
    }
    private void preorder2(Node root, List<Integer> res) {
        if(root==null) return;
        res.add(root.val);
        List<Node> child = root.children;
        for(Node n: child) {
            preorder2(n, res);
        }
               
    }
}