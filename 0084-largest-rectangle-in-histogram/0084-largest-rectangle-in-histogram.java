class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxarea = 0;

        for(int i = 0; i <= heights.length; i++){
            int h = i == heights.length ? 0 : heights[i];

            while(!stack.isEmpty() && heights[stack.peek()] > h){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                int area = height * width;
                maxarea = Math.max(area, maxarea);
            }
            stack.push(i);
        }
        return maxarea;
    }
}