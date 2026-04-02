class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i<emails.length; i++) {
            String localName = emails[i].split("@")[0];
            localName = localName.split("\\+")[0];
            localName = localName.replace(".","");
            set.add(localName + "@" + emails[i].split("@")[1]);
        }
        return set.size();
        
    }
}