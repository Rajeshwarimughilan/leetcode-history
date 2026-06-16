class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] check = new int[nums.length+1];
        for(int n : nums){
            check[n] = n;
        }

        for(int i = 1 ; i <= nums.length; i++){
            if(check[i] != i) res.add(i);
        }

        return res;
    }
}