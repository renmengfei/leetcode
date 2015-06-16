//Method 1: O(N) O(1)
public int maxProfit(int[] prices) {
	int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
	int sale1 = 0, sale2 = 0;
	for (int price : prices) {
		sale2 = Math.max(sale2, buy2 + price);
		buy2 = Math.max(buy2, sale1 - price);
		sale1 = Math.max(sale1, buy1 + price);
		buy1 = Math.max(buy1, -price);
	}
	return sale2;
}


// Method 2: two scan
// 分割点找 dp[i]左边的best-i, 右边的best-i
public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        if(prices.length<2) return result;
        
        // DP P(i-k)+P(k-j)
        int[] dp = new int[prices.length];
        // left to right
        int min = prices[0];
	int maxprofit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>min){
		maxprofit = Math.max(maxprofit, prices[i]-min);
	    }
            min = Math.min(min, prices[i]);
            dp[i] = maxprofit;
        }
        // right to left
        maxprofit = 0;
        int max = prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            if(prices[i]<max){
                maxprofit = Math.max(maxprofit, max-prices[i]);
            }
            max = Math.max(max, prices[i]);
            result = Math.max(result, dp[i]+maxprofit);
        }
        return result;
    }
}



