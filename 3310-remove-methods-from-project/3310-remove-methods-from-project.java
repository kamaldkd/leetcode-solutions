class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // Construct Graph:- directed
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[n];

        for(int[] invocation : invocations) {
            graph.get(invocation[0]).add(invocation[1]); // a -> b
            indegree[invocation[1]]++;
        }

        // find all suspiceos methods using bfs/ or dfs
        boolean[] sus = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(k);
        sus[k] = true;
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int func : graph.get(curr)) {
                indegree[func]--;
                if(!sus[func]) {
                    sus[func] = true;
                    q.offer(func);
                }
            }
        }

        // check if any of the suspicous node has an indegree from regular node/func
        boolean allSusValid = true;
        List<Integer> rem = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(sus[i] && indegree[i] != 0) allSusValid = false;
            else if(!sus[i]) rem.add(i);
        }

        if(!allSusValid) {
            List<Integer> allFunc = new ArrayList<>();
            for(int i=0; i<n; i++) allFunc.add(i);
            return allFunc;
        }

        return rem;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna