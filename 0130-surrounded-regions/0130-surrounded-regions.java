class Solution {
    List<List<Integer>> idxs = new ArrayList<>();
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i = 0 ; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O'){
                    boolean[][] visited = new boolean[rows][cols];
                    idxs.clear();
                    if(!check(board, i, j, visited, idxs)){
                        for(List<Integer> idx: idxs){
                            board[idx.get(0)][idx.get(1)] = 'X';
                        }
                    }
                }
            }
        }
        return;
    }

    public boolean check(char[][] board, int i, int j, boolean[][] visited, List<List<Integer>> idxs){
        if(visited[i][j]) return false;

        if(i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1){
            return true;
        }

        visited[i][j] = true;
        idxs.add(Arrays.asList(i, j));

        boolean a = false, b = false, c = false, d = false;

        if(i - 1 >= 0 && !visited[i-1][j] && board[i-1][j] == 'O'){
            a = check(board, i - 1, j, visited, idxs);
        }

        if(j - 1 >= 0 && !visited[i][j-1] && board[i][j-1] == 'O'){
            b = check(board, i, j - 1, visited, idxs);
        }

        if(i + 1 <= board.length - 1 && !visited[i+1][j] && board[i+1][j] == 'O'){
            c = check(board, i + 1, j, visited, idxs);
        }

        if(j + 1 <= board[0].length - 1 && !visited[i][j+1] && board[i][j+1] == 'O'){
            d = check(board, i, j + 1, visited, idxs);
        }

        return a || b || c || d;
    }
}