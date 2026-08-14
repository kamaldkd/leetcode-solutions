class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) graph.add(new ArrayList<>());
        
        // Build Graph
        for(int path[] : paths) {
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }

        int[] flowers = new int[n]; 

        // Assign flower to every garden
        for(int garden = 1; garden <= n; garden++) {

            boolean[] used = new boolean[5];

            // Check flowers used by neighbors
            for(int neighbor : graph.get(garden)) {
                used[flowers[neighbor-1]] = true;
            }

            // Pick any unused flower
            for(int flower = 1; flower <= 4; flower++) {
                if(!used[flower]) {
                    flowers[garden-1] = flower;
                    break;
                }
            }
        }

        return flowers;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna