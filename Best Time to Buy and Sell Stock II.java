public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
            
        int i = 0;
        int pro = 0;
        for(i = 0;i < prices.length-1;i++){
            if(prices[i+1] > prices[i])
                pro += prices[i+1]-prices[i];
        }
        return pro;
    }
}
