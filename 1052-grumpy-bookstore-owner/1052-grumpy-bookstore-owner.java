class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left = 0;
        int curr = 0;
        int start = 0;
        int maxcurr = 0;
        int total = 0;
        for(int i = 0; i < grumpy.length; i++){
            if(grumpy[i] == 1){
                    curr += customers[i];
                }
            if( i >= minutes){
                if(grumpy[left] == 1){
                    curr -= customers[left];
                } 
                left++;
            }
            if(curr > maxcurr){
                    maxcurr = curr;
                    start = left;
                }      
        }

        for(int j = start; j < start + minutes; j++){
            grumpy[j] = 0;
        }

        for(int k = 0; k < customers.length; k++){
            if(grumpy[k] == 0){
                total += customers[k];
            }
        }
        return total;
    }
}