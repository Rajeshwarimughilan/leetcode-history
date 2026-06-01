class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        compute_subset(nums, new ArrayList<>(), 0);
        return res;
    }

    public void compute_subset(int[] nums, ArrayList<Integer> curr, int start){
        res.add(new ArrayList<>(curr));

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            compute_subset(nums, curr, i+1);
            curr.remove(curr.size() - 1);
        }
    }
}