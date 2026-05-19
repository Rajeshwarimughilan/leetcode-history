class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 1;
        //descending suffix --> changing this wont give smaller permutation caus eits already the last permutation
        while(i > 0 && nums[i-1] >= nums[i]){
            i--;
        }

        if(i == 0){
            reverse(nums, 0, n-1);
            return;
        }
        int pivot = i - 1;
        int j = n - 1;
        while(nums[j] <= nums[pivot]){
            j--;
        }

        swap(nums, pivot, j);
        reverse(nums, i, n-1);
    }

    public void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i]; nums[i] = nums[j]; nums[j] = temp;
            i++;j--;
        }
        return;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i]; nums[i] = nums[j]; nums[j] = temp;
        return;
    }
}