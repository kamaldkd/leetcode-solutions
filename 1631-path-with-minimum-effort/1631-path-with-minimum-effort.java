class Solution {
    static class Pair{
        final int row;
        final int col;
        final int effort;
        public Pair(int row, int col, int effort){
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }
    public boolean isValid(int newRow, int newCol, int n, int m) {
        return newRow >= 0 && newRow < n && newCol >= 0 && newCol < m;
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length; // rows
        int m = heights[0].length; // cols
        int[][] efforts = new int[n][m];
        
        for(int[] eff : efforts) {
            Arrays.fill(eff, Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.effort, b.effort));
        pq.offer(new Pair(0, 0, 0));

        int[] delRow = {-1, +0, +1, +0};
        int[] delCol = {+0, +1, +0, -1};

        while(!pq.isEmpty()) {
            Pair current = pq.poll();
            int row = current.row;
            int col = current.col;
            int effort = current.effort;

            if(row == n - 1 && col == m - 1) {    // because Dijkstra gurantees that the first time you remove the 
                return effort;                    // destination from the queue, you,ve already found its minimum effort
            }

            if(effort > efforts[row][col]) continue;

            for(int i=0; i<4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(isValid(newRow, newCol, n, m)) {

                    int edgeDiff = Math.abs(heights[row][col] - heights[newRow][newCol]);
                    int newEffort = Math.max(effort, edgeDiff);

                    if(newEffort < efforts[newRow][newCol]) {
                        efforts[newRow][newCol] = newEffort;

                        pq.offer(new Pair(newRow, newCol, newEffort));
                    }
                }
            }
        }
        return efforts[n-1][m-1];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna