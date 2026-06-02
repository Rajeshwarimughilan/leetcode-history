class Solution {
    public int[] dailyTemperatures(int[] temps) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temps.length];  

        for(int i = 0; i < temps.length; i++){
            while(!stack.isEmpty() && temps[stack.peek()] < temps[i]){
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }

        return res;

    }
}