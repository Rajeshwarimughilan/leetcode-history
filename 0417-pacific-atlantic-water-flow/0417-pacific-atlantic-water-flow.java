class Solution {
    boolean pacific = false;
    boolean atlantic = false;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                pacific = false;
                atlantic = false;
                boolean[][] visited = new boolean[rows][cols];
                check(heights, i, j, visited);
                if(pacific && atlantic){
                    ArrayList<Integer> curr = new ArrayList<>();
                    curr.add(i);curr.add(j);
                    res.add(curr);
                }
            }
        }
        return res;
    }

    public void check(int[][] grid, int i, int j, boolean[][] visited){
        if(visited[i][j]) return;
        visited[i][j] = true;

        if(i == 0 || j == 0)pacific = true;
        if(i == grid.length-1 || j == grid[0].length-1) atlantic = true;

        if(pacific && atlantic){
            visited[i][j] = false;
            return;
        }

        if(i - 1 >= 0 && grid[i-1][j] <= grid[i][j]) check(grid, i-1, j, visited);
        if(i + 1 < grid.length && grid[i+1][j] <= grid[i][j]) check(grid, i+1, j, visited);
        if(j - 1 >= 0 && grid[i][j-1] <= grid[i][j]) check(grid, i, j-1, visited);
        if(j + 1 < grid[0].length && grid[i][j+1] <= grid[i][j]) check(grid, i, j+1, visited);

        visited[i][j] = false;
        return;
    }
}