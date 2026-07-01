class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxidx = new boolean[9][9];

        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                char ch = board[r][c];
                if(ch == '.') continue;

                int num = ch - '1';
                int idx = ((r/3) * 3 + (c/3));

                if(rows[r][num] || cols[c][num] || boxidx[idx][num]) return false;
                
                rows[r][num] = true;
                cols[c][num] = true;
                boxidx[idx][num] = true;
            }
        }
        return true;
    }
}