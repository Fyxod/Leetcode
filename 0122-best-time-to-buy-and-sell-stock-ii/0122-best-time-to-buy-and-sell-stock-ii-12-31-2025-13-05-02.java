class Solution {
    public int maxProfit(int[] prices) {
        int p = 0;
        int n = prices.length;
        for(int i = 1; i < n; i++){
            if(prices[i] > prices[i - 1]) p += prices[i] - prices[i - 1];
        }
        return p;
    }
}