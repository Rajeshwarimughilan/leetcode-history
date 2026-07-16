class Solution {
    public int pivotIndex(int[] nums) {
        int[] forward = new int[nums.length];
        int[] backward = new int[nums.length];

        int i = 0;int j = nums.length - 1;
        forward[0] = nums[i];
        backward[j] = nums[j];
        
        while(i < nums.length - 1 && j > 0){
            forward[i + 1] = forward[i] + nums[i+1];
            backward[j - 1] = backward[j] + nums[j-1];
            i++;
            j--;
        }

        for(int k = 0; k < nums.length; k++){
            if(forward[k] == backward[k]) return k;
        }
        return -1;
    }
}