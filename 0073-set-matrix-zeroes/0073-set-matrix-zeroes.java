class Solution {
    // static class Pair {
    //     int row;
    //     int col;
    //     Pair(int row, int col) {
    //         this.row = row;
    //         this.col = col;
    //     }
    // }
    public void setZeroes(int[][] matrix) {
        boolean rowHasZero = false, colHasZero = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                colHasZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                rowHasZero = true;
                break;
            }
        }

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        for (int r = 1; r < matrix.length; r++) {
            for (int c = 1; c < matrix[0].length; c++) {
                if (matrix[r][0] == 0 || matrix[0][c] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        if (rowHasZero) {
            for (int r = 0; r < matrix.length; r++) {
                matrix[r][0] = 0;
            }
        }

        if (colHasZero) {
            for (int c = 0; c < matrix[0].length; c++) {
                matrix[0][c] = 0;
            }
        }
    }
    // public void fillRC(int[][] matrix, int row, int col) {
    //     int m = matrix.length;
    //     int n = matrix[0].length;

    //     //making upper part of col: zero
    //     for(int i = row-1; i >= 0; i--) {
    //         matrix[i][col] = 0;
    //     }
    //     //making lower part of col: zero
    //     for(int i = row+1; i <= m-1; i++) {
    //         matrix[i][col] = 0;
    //     }
    //     //making left part of row: zero
    //     for(int j = col-1; j >= 0; j--) {
    //         matrix[row][j] = 0;
    //     }
    //     //making right part of row: zero
    //     for(int j = col+1; j <= n-1; j++) {
    //         matrix[row][j] = 0;
    //     }
    // }
}