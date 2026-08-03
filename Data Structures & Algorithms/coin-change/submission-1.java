
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return dfs(coins, amount, memo);
    }

    private int dfs(int[] coins, int amt, int[] memo) {
        if (amt == 0) return 0;
        if (amt < 0) return -1;
        if (memo[amt] != -2) return memo[amt];

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = dfs(coins, amt - coin, memo);
            if (res != -1) {
                minCoins = Math.min(minCoins, 1 + res);
            }
        }

        memo[amt] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        return memo[amt];
    }
}