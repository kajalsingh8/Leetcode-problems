class Solution {
    public int uniquePaths(int m, int n) {
        int N = n + m - 2; // Total steps we need to take (down + right)
        int r = m - 1; // Number of down movements (or right, both work)
        double res = 1;

        // Calculate combination (N choose r) = N! / (r! * (N - r)!)
        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
        
        return (int) res;
    }
}
