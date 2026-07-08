class Solution {
    public int maxProfit(int[] prices) {
        int i = 0;
        int j = 1;
        int max = 0;

        while(i<j && j<prices.length){
            max = Math.max(max, (prices[j]-prices[i]));
            if(prices[i] > prices[j]){
                i = j;
                j++;
            }else{
                j++;
            }
        }

        return max;
    }
}
