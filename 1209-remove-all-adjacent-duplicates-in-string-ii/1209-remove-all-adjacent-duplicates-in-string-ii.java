class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> charSt = new Stack<>();
        Stack<Integer> count = new Stack<>();

        for(char c: s.toCharArray()) {
            
            if(charSt.isEmpty() || charSt.peek()!=c) {
                charSt.push(c);
                count.push(1);
            } else {
                charSt.push(c);
                count.push(count.pop()+1);
            }
            if(count.peek() == k) {
                int remove = count.pop();
                while(remove>0) {
                    charSt.pop();
                    remove--;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for(char c: charSt) {
            res.append(c);
        }
        return res.toString();
        
    }
}