class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int idx = 0;
        while(idx < matrix.length){
            int col = matrix[0].length - 1;
            if(matrix[idx][col] >= target){
                return binsearch(matrix ,idx, target);
            }
            idx++;
        }
        return false;
    }

    public static boolean binsearch(int[][] mat, int idx, int target){
        int low = 0;int high = mat[0].length - 1;
        while( low <= high){
            int mid = low + (high - low) / 2;

            if(mat[idx][mid] == target) return true;
            else if(mat[idx][mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}