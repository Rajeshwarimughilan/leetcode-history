class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 0; i < matrix[0].length; i++){
            if(!check(matrix, 0, i)) return false;;
        }
        for(int j = 0; j < matrix.length; j++){
            if(!check(matrix, j, 0)) return false;;
        }

        return true;
    }

    public boolean check(int[][] matrix, int row, int col){
        row++; 
        col++;
        while(row < matrix.length && col < matrix[0].length){
            if(matrix[row][col] != matrix[row-1][col-1]) return false;
            row++;col++;
        }
        return true;
    }
}