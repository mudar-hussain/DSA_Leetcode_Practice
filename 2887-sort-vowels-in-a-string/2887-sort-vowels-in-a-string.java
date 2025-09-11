class Solution {
    public String sortVowels(String s) {
        String vowels = "aeiouAEIOU";
        List<Character> vowelList = new ArrayList<>();
        char[] arr = s.toCharArray();

        for(int i = 0; i<arr.length; i++) {
            if (vowels.indexOf(arr[i]) != -1){
                vowelList.add(arr[i]);
            }
        } 
        Collections.sort(vowelList);
        int idx = 0;
        for(int i = 0; i<arr.length; i++) {
            if (vowels.indexOf(arr[i]) != -1){
                arr[i] = vowelList.get(idx++);
            }
        } 

        return new String(arr);
    }
}