class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for(int a : prices){
            if(a < min) min = a;
            else if(a - min > profit) profit = a - min;
        }
        return profit;
    }
}