class Solution {

    public int[] dp;

    public int climbStairs(int n) {
        dp = new int[n];

        for(int i=0; i<n; i++){
            dp[i] = -1;
        }
        return test(n, 0);
    }

    public int test(int n, int i){
        if (i >= n) return i == n ? 1 : 0;
        if(dp[i] != -1) return dp[i];

        int left = test(n, i+1);
        int right = test(n, i+2);

        return dp[i] = left + right;
    }
}
