class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>(), target);
        return res;
    }

    void backtrack(int idx, int[] nums, List<List<Integer>> res, List<Integer> curr, int target){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        if(target < 0) return;

        for(int i = idx; i < nums.length; i++){
            curr.add(nums[i]);
            backtrack(i, nums, res, curr, target-nums[i]);//Elements can be reused so i not i+1
            curr.remove(curr.size() - 1);
        }

    }
}