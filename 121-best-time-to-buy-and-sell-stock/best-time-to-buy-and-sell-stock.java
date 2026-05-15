class Solution {
    public int maxProfit(int[] prices) {
        int current_profit=0;
        int max_profit=0;
        int min_buying=prices[0];
       for(int current_price : prices)
       {
        max_profit=Math.max(max_profit,current_price-min_buying);
        min_buying=Math.min(current_price,min_buying);
       }
        return max_profit;
    }
}