public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=0) return 0;
        int min = prices[0];
        int result = 0;
        for(int i=1;i<prices.length;i++){
            result = Math.max(prices[i]-min, result);
	    if(prices[i]<min) min=prices[i];
        }
        return result;
    }
}
