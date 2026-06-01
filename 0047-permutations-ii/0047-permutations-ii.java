class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);//to check duplicate
        boolean[] used = new boolean[nums.length];
        compute_perm(nums, new ArrayList<>(), used);
        return ans;
    }

    public void compute_perm(int[] nums, ArrayList<Integer> curr, boolean[] used){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
            
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;


            used[i] = true;
            curr.add(nums[i]);
            compute_perm(nums, curr, used);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}