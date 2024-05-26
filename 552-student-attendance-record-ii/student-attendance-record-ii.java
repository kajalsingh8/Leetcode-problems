class Solution 
{
    /*
        DP: concern only L or P at first 
            insert A into (n-1) string, calculcate by num(left) * num(right)
    */
    int MOD = (int)(1e9 + 7);
    public int checkRecord(int n) 
    {
        long[][] dp = new long[n+1][3]; // end with P / L / P or L in total
        dp[0][0] = dp[0][1] = dp[0][2] = 1; // special cases: 0 is legal
        dp[1][0] = 1;   // end with P
        dp[1][1] = 1;   // end with L
        dp[1][2] = dp[1][0] + dp[1][1];
        for (int i = 2; i <= n; i++)
        {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % MOD;
            dp[i][1] = (dp[i-1][0] + dp[i-2][0]) % MOD;
            dp[i][2] = dp[i][0] + dp[i][1];
        }
        
        long res = dp[n][2];      
        for (int i = 0; i < n; i++) // insert A into (n-1)-length strings
        {
            long temp = (dp[i][2] * dp[n-1-i][2]) % MOD; // ways on left  * ways on right 
            res = (res + temp) % MOD; 
        }
        
        return (int)res;
    }
} 