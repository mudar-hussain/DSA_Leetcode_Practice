class TopVotedCandidate {
    int[] lead;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.lead = new int[persons.length];
        int maxVotes = 0;
        int winner = -1;
        int[] votes = new int[persons.length];
        for(int i = 0; i<persons.length; i++) {
            votes[persons[i]]++;
            if(votes[persons[i]]>=maxVotes) {
                maxVotes = votes[persons[i]];
                winner = persons[i];
            }
            lead[i] = winner;
        }
    }
    
    public int q(int target) {
        int low = 0, high = times.length-1;
        int idx = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if (times[mid]<=target) {
                idx = mid;
                low = mid+1;
            } else high = mid-1;
        }
        return lead[idx];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */