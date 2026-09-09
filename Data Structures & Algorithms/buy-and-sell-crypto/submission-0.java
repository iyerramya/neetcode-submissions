class Solution {
    public int maxProfit(int[] prices) {
        int sp = 0, bp = 0, profit = 0;
        for(int i = prices.length-1; i>=0; i--) {
            if(prices[i] > sp) {
                sp = prices[i];
            } else {
                bp = prices[i];
                if((sp-bp) > profit) {
                    profit = (sp-bp);
                }
            }
        }
        return profit;
    }
}
