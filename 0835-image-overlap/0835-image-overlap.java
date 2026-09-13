class Solution {
    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y; 
        }
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        ArrayList<Pair> ones1 = new ArrayList<>();
        ArrayList<Pair> ones2 = new ArrayList<>();

        int n = img1.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(img1[i][j] == 1) ones1.add(new Pair(i, j));
                if(img2[i][j] == 1) ones2.add(new Pair(i, j));
            }
        }
        
        int ans = 0;
        for(Pair i1 : ones1) {
            int x = i1.x;
            int y = i1.y;
            
            for(Pair i2 : ones2) {
                int dx = i2.x - x;
                int dy = i2.y - y;
                int temp = 0;
                for(int i = 0; i < ones1.size(); i++) {
                    Pair p = ones1.get(i);
                    int nx = p.x + dx;
                    int ny = p.y + dy;

                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

                    if(img2[nx][ny] == 1) temp++;
                }

                ans = Math.max(ans, temp);
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna