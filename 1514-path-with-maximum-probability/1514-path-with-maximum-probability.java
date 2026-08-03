class Solution {
    static class Pair {
        int node;
        double probability;

        Pair(int node, double probability) {
            this.node = node;
            this.probability = probability;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        // 1. Build Graph
        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>()); // Initialisation

        for(int i = 0; i < edges.length; i++) { // edges[i] = {u, v} - An undirected edge
            int u = edges[i][0],
                v = edges[i][1];

            graph.get(u).add(new Pair(v, succProb[i])); // because the dge is undirected so, u -> v & v -> u
            graph.get(v).add(new Pair(u, succProb[i]));
        }

        // 2. probabilities array:- where probabilities[i] will store maximum probality of node i
        double[] probabilities = new double[n];
        // Arrays.fill(probabilities, Double.MIN_VALUE); // we don't have to fill this array brecause the minimum range of probalitiy is already zero
        probabilities[start_node] = 1.0; // it should not be zero because we are already at start node, so the probaility is 
                                         // if we put 0 here then our answer will be wrong because, we are multipying it with another probabilities, so always the new probabilities will become zero

        // 3. MAX HEAP:- Priority Queue
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
        pq.offer(new Pair(start_node, 1.0));

        while(!pq.isEmpty()) {
            Pair current = pq.poll();

            if(current.node == end_node) return current.probability;

            if(current.probability < probabilities[current.node]) continue;

            for(Pair edge : graph.get(current.node)) {
                double newProbability = current.probability * edge.probability;

                if(newProbability > probabilities[edge.node]) {
                    probabilities[edge.node] = newProbability;

                    pq.offer(new Pair(edge.node, newProbability));
                }
            }
        }

        return 0.0;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna