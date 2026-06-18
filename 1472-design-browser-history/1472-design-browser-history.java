class BrowserHistory {
    public class Node {
        String url;
        Node next, prev;
        public Node(String url) {
            this.url = url;
            this.next = null;
            this.prev = null;
        }
    }
    private Node curr;
    public BrowserHistory(String homepage) {
        curr = new Node(homepage);        
    }
    
    public void visit(String url) {
        Node next = new Node(url);
        curr.next = next;
        next.prev = curr;
        curr = next;        
    }
    
    public String back(int steps) {
        while(curr.prev != null && steps-->0) {
            curr = curr.prev;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        while(curr.next != null && steps-->0) {
            curr = curr.next;
        }
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */