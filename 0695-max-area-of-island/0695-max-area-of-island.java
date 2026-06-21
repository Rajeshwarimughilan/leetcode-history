class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] used = new boolean[grid.length][grid[0].length];
        int maxland = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int curr = calculate(grid, i, j, used);
                    maxland = Math.max(maxland, curr);
                }
            }
        }
        return maxland;
    }

    public int calculate(int[][] grid, int i, int j, boolean[][] used){
        used[i][j] = true;
        int ans = 1;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        for(int k = 0; k < 4; k++){
            int nr = i + dr[k];
            int nc = j + dc[k];

            if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1 && !used[nr][nc]){
                ans += calculate(grid, nr, nc, used);
            }
        }
        return ans;
    }
}