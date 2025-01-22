import java.util.*;

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length, m = isWater[0].length;
        int[][] ans = new int[n][m];
        for (int[] row : ans) Arrays.fill(row, -1); // Initialize the ans array with -1
        Queue<int[]> q = new LinkedList<>();

        // Add all water cells to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    ans[i][j] = 0; // Water cells have height 0
                    q.add(new int[]{i, j});
                }
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        // Perform BFS
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0], y = cell[1];
            for (int k = 0; k < 4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && ans[newX][newY] == -1) {
                    ans[newX][newY] = ans[x][y] + 1;
                    q.add(new int[]{newX, newY});
                }
            }
        }

        return ans;
    }
}