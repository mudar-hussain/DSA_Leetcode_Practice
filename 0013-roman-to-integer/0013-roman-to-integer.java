class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int n = s.length();
        char prev = s.charAt(0);
        int value = map.get(prev);
        for(int i = 1; i<n; i++) {
            char curr = s.charAt(i);
            if(map.get(prev)<map.get(curr)){
                value += (map.get(curr)-2*map.get(prev));
            } else {
                value += map.get(curr);
            }
            prev = curr;
            
        }
        return value;    
    }
}