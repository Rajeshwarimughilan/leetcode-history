class Solution {
    public int islandPerimeter(int[][] grid) {
        int perm = 0;
        int shared = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    if(i + 1 < rows && grid[i + 1][j] == 1){
                        shared++;
                    }

                    if(j + 1 < cols && grid[i][j + 1] == 1){
                        shared++;
                    }

                    perm++;
                }
            }
        }

        return perm * 4 - shared * 2;
    }
}