class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] power = new long[n], powerFromRight = new long[n];

        //Left traversal - Accumualate with current station power
        long currPower = 0;
        for(int i=0;i<n;i++){
            currPower += power[i] + stations[i]; //Accumulate (any negative power accumulated due to expiry) and (power of curr city)
            power[i] = currPower; //Update current city's power
            if(i+r+1<n) power[i+r+1] -= stations[i]; //Expire current city's power
        }

        //Right traversal - Accumulate without current station power 
        currPower = 0;
        for(int i=n-1;i>=0;i--){
            long rPower = powerFromRight[i]; //Any negative power accumulated due to expiry
            powerFromRight[i] += currPower; //Add accumulated power from right for current city
            if(i-r-1>=0) powerFromRight[i-r-1] -= stations[i];  //Expire current city's power
            currPower += stations[i] + rPower; //Accumulate (any negative power accumulated due to expiry) and (power of curr city)
        }

        long minPower = Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            power[i] += powerFromRight[i];
            minPower = Math.min(minPower, power[i]); //minPower is the minimum power of any city
        } 
        long maxPower = minPower+k, maxMinPower = minPower; //maxPower is minPower+k, maxMinPower is result and has to be atleast minPower

        while(minPower<=maxPower){
            long mid = (minPower+maxPower)/2;
            if(canSatisfy(power, mid, (long)k, r)){ //minPower=mid can be satisfied using k extra stations
                maxMinPower = mid;
                minPower = mid+1;
            }
            else
                maxPower = mid-1;
        }
         
        return maxMinPower;
    }

    private boolean canSatisfy(long[] power, long minPower, long k, int r){
        int n = power.length;
        long currPower = 0, accumulatedPower[] = new long[n];

        for(int i=0;i<n;i++){
            long accPow = accumulatedPower[i]; //Any negative power accumulated due to expiry 
            accumulatedPower[i] += currPower; //Accumulate additional power from previous stations
            long powerNeeded = minPower - (power[i]+accumulatedPower[i]); //Do we need to add more power to this city?

            if(powerNeeded>0){
                if(k<powerNeeded) return false; //We don't have enough stations left to reach the desired minPower
                k -= powerNeeded; //Reduce # of stations
                currPower += powerNeeded; //Current power increases by # of stations added
                if(i+2*r+1<n) accumulatedPower[i+2*r+1] -= powerNeeded; //Stations not added to current city but the farthest one for which current city is still in range
            }

            currPower += accPow; //Accumulate any negative power due to expiry
        }

        return true;
    }
}