class Solution {
    public boolean maxSubstringLength(String s, int k) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for(int i = 0; i<n; i++) {
            int c = s.charAt(i)-'a';
            if(first[c] == -1) first[c] = i;
            last[c] = i;
        }
        List<int[]> segments = new ArrayList<>();
        for(int i = 0; i<26; i++) {
            if(first[i] == -1) continue;
            int start = first[i], end = last[i];
            int curr = start;
            boolean isValid = true;
            while(curr<=end) {
                int c = s.charAt(curr)-'a';
                if(first[c]<start) {
                    isValid = false;
                    break;
                }
                end = Math.max(end, last[c]);
                curr++;
            }
            if(isValid && (start>0 || end<n-1)) {
                segments.add(new int[]{start, end});
            }
        }
        Collections.sort(segments, (a,b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int prev = -1;
        for(int[] seg: segments) {
            if(seg[0]>prev) {
                count++;
                prev = seg[1];
            }
        }
        return count >= k;
        
    }
}