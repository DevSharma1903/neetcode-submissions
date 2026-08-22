class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(nums, 0);
    }

    public int dfs(int[] nums, int i){
        if(i>=nums.length) return 0;
        if(dp[i] != -1) return dp[i];

        return dp[i] = Math.max(dfs(nums, i+1), nums[i]+dfs(nums, i+2));
    }
}
