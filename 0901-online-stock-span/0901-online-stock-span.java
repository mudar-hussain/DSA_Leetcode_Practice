class Pair {
    public int key;
    public int freq;
    Pair(int key, int freq) {
        this.key = key;
        this.freq = freq;
    }
}
class StockSpanner {
    Stack<Pair> st;

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int freq = 1;
        while(!st.isEmpty() && st.peek().key<=price) {
            freq += st.pop().freq;
        }
        st.push(new Pair(price, freq));
        return freq;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */