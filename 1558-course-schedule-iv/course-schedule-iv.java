import java.util.*;

class Solution {
    // Helper function to perform DFS and record prerequisites
    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, Set<Pair<Integer, Integer>> prerequisites, int start) {
        // Mark the current node as visited
        visited[node] = true;

        // Add the pair (start, node) to the set if `start` is not -1
        if (start != -1) {
            prerequisites.add(new Pair<>(start, node));
        }

        // Explore all neighbors of the current node
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, prerequisites, start);
            }
        }
    }

    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] q) {
        // Step 1: Build the adjacency list representation of the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] p : pre) {
            adj.get(p[0]).add(p[1]);
        }

        // Step 2: Use DFS to compute all prerequisites
        Set<Pair<Integer, Integer>> prerequisites = new HashSet<>();
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n]; // Reset visited array for each node
            dfs(i, adj, visited, prerequisites, i);
        }

        // Step 3: Answer each query
        List<Boolean> result = new ArrayList<>();
        for (int[] query : q) {
            result.add(prerequisites.contains(new Pair<>(query[0], query[1])));
        }
        return result;
    }
}