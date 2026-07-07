class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    
    int m = matrix.length;
    int n = matrix[0].length;
    // One binary search: O(log(m × n)) — a cleaner implementation that treats the matrix as a virtual 1D sorted array.
    // we can do that because it is clearly stated in the problem statement that in the matrix The first integer of each row is greater than the last integer of the previous row.'
    int low = 0;
    int high = m * n - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      // take an example, copy all the elements of the matrix into one single line or array and assign each an index starting from 0 and do dry run to understand how we can find row and vol of that index.
      int row = mid / n;
      int col = mid % n;

      if (matrix[row][col] == target)
        return true;
      else if (matrix[row][col] < target)
        low = mid + 1;
      else
        high = mid - 1;
    }

    return false;
  }
}