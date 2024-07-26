public class ReplaceSurrounded {
    
    // Function to check if given cell (row, col) can be included in DFS
    static boolean isSafe(char mat[][], int visited[][], int row, int col, int M, int N) {
        // row number is in range, column number is in range and value is 'O' and not yet visited
        return (row >= 0 && row < M && col >= 0 && col < N && mat[row][col] == '-' && visited[row][col] == 0);
    }
    
    // Utility function to do DFS for a 2D boolean matrix. It only considers the 4 neighbors as adjacent vertices
    static void floodFill(char mat[][], int visited[][], int row, int col, int M, int N) {
        // These arrays are used to get row and column numbers of 4 neighbors of a given cell
        int rowNbr[] = {-1, 1, 0, 0};
        int colNbr[] = {0, 0, -1, 1};
        
        // Mark this cell as visited
        visited[row][col] = 1;
        mat[row][col] = 'O';
        
        // Recur for all connected neighbours
        for (int k = 0; k < 4; ++k) {
            if (isSafe(mat, visited, row + rowNbr[k], col + colNbr[k], M, N)) {
                floodFill(mat, visited, row + rowNbr[k], col + colNbr[k], M, N);
            }
        }
    }
    
    // Function to replace surrounded 'O' with 'X'
    static void replaceSurrounded(char mat[][], int M, int N) {
        // Step 1: Replace all 'O' with '-'
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 'O') {
                    mat[i][j] = '-';
                }
            }
        }
        
        // Step 2: Call floodFill for all '-' on edges
        int visited[][] = new int[M][N];
        for (int i = 0; i < M; i++) {
            if (mat[i][0] == '-') {
                floodFill(mat, visited, i, 0, M, N);
            }
            if (mat[i][N - 1] == '-') {
                floodFill(mat, visited, i, N - 1, M, N);
            }
        }
        for (int i = 0; i < N; i++) {
            if (mat[0][i] == '-') {
                floodFill(mat, visited, 0, i, M, N);
            }
            if (mat[M - 1][i] == '-') {
                floodFill(mat, visited, M - 1, i, M, N);
            }
        }
        
        // Step 3: Replace all remaining '-' with 'X'
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == '-') {
                    mat[i][j] = 'X';
                }
            }
        }
    }
    
    // A utility function to print the matrix
    static void printMatrix(char mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char mat[][] = {
                {'X', 'O', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'O', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'}
        };
        
        System.out.println("Input Matrix:");
        printMatrix(mat);
        
        replaceSurrounded(mat, mat.length, mat[0].length);
        
        System.out.println("Output Matrix:");
        printMatrix(mat);
    }
}
