class MyLinkedList {
    private static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    Node head = null;
    Node tail = null;
    int size = 0;

    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if(index<0 || index>=this.size) return -1;
        Node curr = this.head;
        while(index-->0) {
            curr = curr.next;
        }
        return curr.val;
    }
    
    public Node getNodeAtIndex(int index) {
        if(index<0 || index>=this.size) return null;
        Node curr = this.head;
        while(index-->0) {
            curr = curr.next;
        }
        return curr;
    }
    
    public void addAtHead(int val) {
        Node newHead = new Node(val, this.head);
        this.head = newHead;
        if(this.tail == null) this.tail = newHead;
        this.size++;
    }
    
    public void addAtTail(int val) {
        if(this.size == 0) {
            addAtHead(val);
            return;
        } 
        this.tail.next = new Node(val);
        this.tail = this.tail.next;
        this.size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index<0 || index>this.size) return;
        else if (index == 0) addAtHead(val);
        else if (index == this.size) addAtTail(val);
        else {
            Node prev = getNodeAtIndex(index-1);
            prev.next = new Node(val, prev.next);
            this.size++;
        }           
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size) return;
        else if(size == 1) {
            this.head = null;
            this.tail = null;
        } else if(index == 0) this.head = this.head.next;
        else if(index == size-1) {
            this.tail = getNodeAtIndex(index-1);
            this.tail.next = null;
        } else {
            Node prev = getNodeAtIndex(index-1);
            prev.next = prev.next.next;
        }
        this.size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */