class Solution {
    public boolean helper(int numCourses, List<List<Integer>> adj, Queue<Integer> q, int[] indegree) {
        int processedCourses = 0;
        while(!q.isEmpty()) {
            int prerequisite = q.poll();
            for(int course : adj.get(prerequisite)) {
                indegree[course]--;

                if(indegree[course] == 0) q.add(course);
            }
            processedCourses++;
        }

        return processedCourses == numCourses;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        // creating adj list to represent in the form of graph 
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // prerequisite -> course, e.g. [0] -> {1, 2, 3}
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];

            indegree[course]++;

            adj.get(prerequisite).add(course);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        return helper(numCourses, adj, q, indegree);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna