class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int minidx = 0;
        List<Integer> res = new ArrayList<>();
        if(arr.length < k) return res;
        int val = Math.abs(arr[minidx] - x);

        for(int i = 1; i < arr.length; i++){
            if(Math.abs(arr[i] - x) < val){
                val = Math.abs(arr[i] - x);
                minidx = i;
            }
        }

        int left = minidx;
        int right = minidx;

        while(right - left + 1 < k){
            if(left == 0){
                right++;
            }
            else if(right == arr.length - 1){
                left--;
            }
            else{
                int leftdiff = Math.abs(arr[left - 1] - x);
                int rightdiff = Math.abs(arr[right + 1] - x);

                if(leftdiff <= rightdiff) left--;
                else right++;
            }
        }
        
        for(int i = left; i <= right; i++){
            res.add(arr[i]);
        }

        return res;

        
    }
}