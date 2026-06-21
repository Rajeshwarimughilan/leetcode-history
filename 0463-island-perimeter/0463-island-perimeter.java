class Solution {
    public int islandPerimeter(int[][] grid) {
        int perm = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    for(int k = 0; k < 4; k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if(nc < 0 || nr < 0 || nc >= cols || nr >= rows || grid[nr][nc] == 0) perm++;
                    }
                }
            }
        }
        return perm;
    }
}