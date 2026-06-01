class Solution {
    public int[][] generateMatrix(int n) {
        int nums = n*n;

        int[][] matrix = new int[n][n];
        int idx = 1;
        int left = 0, right = n-1;
        int top = 0, down = n-1;
       
    while(idx <= nums){
        for(int col = left; col <= right; col++){
            matrix[top][col] = idx++;
        }
        top++;

        for(int row = top; row <= down ; row++){
            matrix[row][right] = idx++;
        }
        right--;

        if(top <= down){for(int col = right; col >= left; col-- ){
            matrix[down][col] = idx++;
        }
        down--;
        }

        if(left <= right){for(int row = down;row >= top  ;row--){
            matrix[row][left] = idx++;
        }
        left++;
       }
    }
    return matrix;
    }
    
}