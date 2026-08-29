class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfaction = 0;
        int extraSatisfaction = 0;
        int currSatisfaction = 0;
        for(int i = 0; i<customers.length; i++) {
            if(grumpy[i] == 0) {
                satisfaction += customers[i];
            }
        }
        int left = 0, right = 0;
        while(right<customers.length) {
            if(right>=minutes) {
                if(grumpy[left] == 1) {
                    currSatisfaction -= customers[left];
                }
                left++;
            }
            if(grumpy[right] == 1) {
                currSatisfaction += customers[right];
            }
            right++;
            extraSatisfaction = Math.max(extraSatisfaction, currSatisfaction);
        }
        
        return satisfaction + extraSatisfaction;
        
    }
}