class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(new boolean[nums.length], res, nums, new ArrayList<>());
        return res;
    }

    static void backtrack(boolean[] used, List<List<Integer>> res, int[] nums, List<Integer> curr){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;

            used[i] = true;
            curr.add(nums[i]);
            backtrack(used, res, nums, curr);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}