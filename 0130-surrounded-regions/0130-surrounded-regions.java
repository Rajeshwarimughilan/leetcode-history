class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        if(rows == 1 ||cols == 1)return;
        for(int i = 1; i < rows - 1; i++){
            for(int j = 1; j < cols - 1; j++){
                boolean[][] visited = new boolean[rows][cols];
               if(board[i][j] == 'O' && !visited[i][j]) if(!check(board, i, j, visited)){
                boolean[][] visited2 = new boolean[rows][cols];
                correct(board, i, j, visited2);
               } 
            }
        }
        return;
    }

    public boolean check(char[][] grid, int i, int j, boolean[][] visited){

        if(visited[i][j])return false;
        if(i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1){
            return true;
        }

        visited[i][j] = true;

        boolean a = false,b = false,c = false,d = false;

        if(i + 1 < grid.length &&!visited[i+1][j] && grid[i+1][j] == 'O') a = check(grid, i+1, j, visited);
        if(j + 1 < grid[0].length &&!visited[i][j+1] && grid[i][j+1] == 'O') b = check(grid, i, j+1, visited);
        if(i - 1 >= 0 &&!visited[i-1][j] && grid[i-1][j] == 'O') c = check(grid, i-1, j, visited);
        if(j - 1 >= 0 &&!visited[i][j-1] && grid[i][j-1] == 'O') d = check(grid, i, j-1, visited);
        
        return a || b || c || d;
    }

    public void correct(char[][] grid, int i, int j, boolean[][] visited){
        if(i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1){
            return;
        }

        grid[i][j] = 'X';

        if(i + 1 < grid.length &&!visited[i+1][j] && grid[i+1][j] == 'O') correct(grid, i+1, j, visited);
        if(j + 1 < grid[0].length &&!visited[i][j+1] && grid[i][j+1] == 'O') correct(grid, i, j+1, visited);
        if(i - 1 >= 0 &&!visited[i-1][j] && grid[i-1][j] == 'O') correct(grid, i-1, j, visited);
        if(j - 1 >= 0 &&!visited[i][j-1] && grid[i][j-1] == 'O') correct(grid, i, j-1, visited);

        return;
    }
}