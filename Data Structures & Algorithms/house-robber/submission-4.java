class Solution {
    public int[] dp;

    public int rob(int[] nums) {
        dp = new int[nums.length];

        Arrays.fill(dp, -1);

        return test(nums, 0);
    }

    public int test(int[] nums, int i){
        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];

        int h1 = test(nums, i+1);
        int h2 = nums[i] + test(nums, i+2);

        return dp[i] = Math.max(h1, h2);
    }
}
