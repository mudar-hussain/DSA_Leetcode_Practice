/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int level = q.size();
            Node leftNode = null;
            while(level-->0) {
                Node currNode = q.poll();
                if(leftNode != null) {
                    leftNode.next = currNode;
                }
                leftNode = currNode;
                if(currNode.left != null) q.offer(currNode.left);
                if(currNode.right != null) q.offer(currNode.right);
            }
        }
        return root;
        
    }
}