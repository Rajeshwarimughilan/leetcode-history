class Solution {
    public int trap(int[] heights) {
        int i = 0; int j = heights.length - 1;
        int leftmax = heights[i];
        int rightmax = heights[j];
        int sum = 0;

        while(i <= j){
            if(heights[i] < heights[j]){
                if(heights[i] > leftmax) leftmax = heights[i];
                sum += leftmax - heights[i];
                i++;
            }
            else{
                if(heights[j] > rightmax) rightmax = heights[j];
                sum += rightmax - heights[j];
                j--;
            }
        }
        return sum;
    }
}