class Solution {
    // TLE
    public void findPaths(int x, int y, int m, int n, int[] paths) {
        if(x == m-1 && y == n-1) {
            paths[0]++;
            return;
        }
        if(x == m-1) {
            findPaths(x, y + 1, m, n, paths);
        }else if(y == n-1) {
            findPaths(x + 1, y, m, n, paths);
        } else {
            findPaths(x, y + 1, m, n, paths);
            findPaths(x + 1, y, m, n, paths);
        }
    }
    // Optimal - DP
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        
        for(int i = 1; i <= n; i++) paths[0][i-1] = 1;
        for(int i = 1; i <= m; i++) paths[i-1][0] = 1;
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }
        
        return paths[m-1][n-1];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna