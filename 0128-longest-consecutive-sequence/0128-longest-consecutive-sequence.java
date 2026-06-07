class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        
        int idx = 1;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1]){
                nums[idx++] = nums[i];
            }
        }
       
        int[] numarr = Arrays.copyOfRange(nums, 0, idx);
        int maxcount = 1;
        int count = 1;
        int i = 0;

        while(i < numarr.length - 1){
            if(numarr[i] + 1 == numarr[i + 1]) count++;
            else count = 1;
            i++;
            maxcount = Math.max(maxcount, count); 
        }
        
        
        return maxcount;
    }
}