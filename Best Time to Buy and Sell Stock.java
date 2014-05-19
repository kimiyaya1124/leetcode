public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        if(prices.length == 1)
            return 0;
        int maxP = 0;
        int lastP = 0;
        for(int i = 1; i < prices.length;i++){
            lastP = Math.max(prices[i]-prices[i-1],prices[i]-prices[i-1]+lastP);
            lastP = Math.max(0,lastP);
            maxP = Math.max(lastP,maxP);
        }
        return maxP;
    }
}
