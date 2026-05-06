class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, res, nums, new ArrayList<>());
        return res;
    }

    static void backtrack(int idx, List<List<Integer>> res, int[] nums, List<Integer> curr){
        res.add(new ArrayList<>(curr));

        for(int i = idx; i < nums.length; i++){
            curr.add(nums[i]);
            backtrack(i + 1, res, nums, curr);
            curr.remove(curr.size() - 1);
        }
    }
}