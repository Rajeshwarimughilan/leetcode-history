class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];

        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                map.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            map.put(nums2[stack.pop()], -1);
        }

        for(int i = 0; i < nums1.length; i++){
            int temp = map.get(nums1[i]);
            res[i] = temp; 
        }

        return res;


    }
}