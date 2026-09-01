class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        
        for(int i = 1; i < points.length; i++) {
            int dx = Math.abs(points[i][0] - points[i - 1][0]);
            int dy = Math.abs(points[i][1] - points[i - 1][1]);
            
            time += Math.max(dx, dy);
        }
        
        return time;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna