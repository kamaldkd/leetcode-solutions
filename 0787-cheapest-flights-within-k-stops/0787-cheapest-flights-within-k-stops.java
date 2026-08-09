
class Solution {
    static class Pair {
       int first; // adjacency node
       int second; // edge weight
       public Pair(int first, int second) {
            this.first = first;
            this.second = second;
       } 
    }
    static class Tuple {
       int first; // stops
       int second; // node
       int third; // distance 
       public Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
       } 
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int flight[] : flights) {
            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, (int) (1e9));
        dist[src] = 0;

        // {stops, node, distance}
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0, src, 0));

        while(!q.isEmpty()) {
            Tuple curr = q.poll();
            int stops = curr.first;
            int node = curr.second;
            int cost = curr.third;

            if(stops > k) continue;
            for(Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.first;
                int adjWeight = neighbor.second;

                if(cost + adjWeight < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + adjWeight;

                    q.offer(new Tuple(stops+1, adjNode, dist[adjNode]));
                }
            }
        }
        if(dist[dst] == (int) (1e9)) return -1;

        return dist[dst];
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna