class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int max_profit = 0;

        for(int i : prices){
            int profit = i - buy;
            if(profit > max_profit){
                max_profit = profit;
            }
            if(buy > i){
                buy = i;
            }
        }
        return max_profit;
    }
}