class Solution {
    int[][] dir = {{-1,0},{0,-1},{0,1},{1,0}}; 
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        char words[] = word.toCharArray();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if( word.charAt(0)==board[i][j] && backtrack(i,j,words,board,0,n,m)){
                    return true;
                }
            }
        }

        return false;
    }

    boolean backtrack(int row, int col, char[] words, char[][] board, int idx, int n, int m) {
    if (idx == words.length) return true;

    if (row < 0 || col < 0 || row >= n || col >= m || (board[row][col] != words[idx])) {
        return false;
    }

    char temp = board[row][col];
    board[row][col] = '$';

    for (int[] d : dir) {
        int nrow = row + d[0];
        int ncol = col + d[1];
        if (backtrack(nrow, ncol, words, board, idx + 1, n, m)) {
            return true;
        }
    }
    board[row][col] = temp;

    return false;
}


}
