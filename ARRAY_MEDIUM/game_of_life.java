class Solution {
    int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int count = 0;
                for(int[] d : dir) {
                    int nrow = i + d[0];
                    int ncol = j + d[1];

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && (board[nrow][ncol] == 1 || board[nrow][ncol] == 2)) {
                        count++;
                    }
                }

                if(count < 2 || count > 3) {
                    if(board[i][j] == 1) board[i][j] = 2; // mark as dead
                }

                if(count == 3 && board[i][j] == 0) {
                    board[i][j] = 3; // mark as alive
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] %= 2;
            }
        }
    }
}
