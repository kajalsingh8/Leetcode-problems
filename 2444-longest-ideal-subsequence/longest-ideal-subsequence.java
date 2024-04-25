class Solution {
    private int solveMemo(String s, int idx, int k, int[][] dp, char ch) {
        // Base Case
        if (idx >= s.length()) {
            return 0;
        }

        // step-2 => if already calculated just return it
        if (dp[idx][ch] != -1) {
            return dp[idx][ch];
        }

        // step-3 => if not calculated yet just calculate it and return
        int take = 0;
        int nontake = 0;
        // Case of take it
        if (Math.abs(ch - s.charAt(idx)) <= k || ch == '#') {
            take = 1 + solveMemo(s, idx + 1, k, dp, s.charAt(idx));
        }
        // case of leave it
        nontake = solveMemo(s, idx + 1, k, dp, ch);

        return dp[idx][ch] = Math.max(take, nontake);
    }




    public int longestIdealString(String s, int k) {
        // DP + Memoization
        int[][] dp = new int[s.length() + 1][130];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return solveMemo(s, 0, k, dp, '#');




        // DP + Tabulation
        // int res = 0;
        // int[] dp = new int[150];
        // for (int i = 0; i < s.length(); i++) {
        //     int asci = s.charAt(i);
        //     for (int j = asci - k; j <= asci + k; j++) {
        //         dp[asci] = Math.max(dp[asci], dp[j]);
        //     }
        //     res = Math.max(res, ++dp[asci]);
        // }
        // return res;
    }
}