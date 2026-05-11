class Solution {
    public int numTrees(int n) {
        //Catalan DP Approach
        int[] dp = new int[n+1];
        dp[0] = 1; dp[1] = 1;
        for(int nodes = 2; nodes <= n; nodes++){
            for(int root = 1; root <= nodes; root++){
                int left = dp[root-1];
                int right = dp[nodes - root];
                dp[nodes] += left * right;
            }
        }
        return dp[n];
    }
}
// INNER LOOP → “Which node becomes root?”
// Why dp[0] = 1?
// Empty subtree is considered ONE valid arrangement.Otherwise multiplication breaks.
// Example, If root is 1:
// left subtree = empty
// right subtree = 2 nodes
// 1×dp[2]
// not zero.