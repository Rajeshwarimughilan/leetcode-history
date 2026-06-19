class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int pile : piles){
            high = Math.max(pile, high);
        }
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(ispossible(piles, mid, h)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
            
        }
        return ans;
    }

    public boolean ispossible(int[] piles, int mid, int h){
        long sum = 0;
        for(int i = 0; i < piles.length; i++){
            int curr = 0;
            if(piles[i] < mid){
                curr = 1;
            }
            else{
                curr = piles[i] / mid;
                curr = piles[i] % mid != 0 ? curr + 1 : curr;
            }
            sum += curr;
        }
        if(sum > h) return false;
        else return true;
    }
}