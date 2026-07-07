class Solution {
    public void rotate(int[][] matrix) {
        /*
         1. transpose of the matrix
        
                1 4 7
                2 5 8
                3 6 9
            
         2. reverse every row

                7 4 1
                8 5 2
                9 6 3
        */

        for(int i = 0; i < matrix[0].length - 1; i++) {
            for(int j = i + 1; j < matrix.length; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix.length - 1;

            while(left < right) {

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
        
    }
}