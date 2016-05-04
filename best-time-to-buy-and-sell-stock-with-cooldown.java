// Method 1: DP
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        
        buy[0]=-prices[0];
        buy[1]=Math.max(-prices[0], -prices[1]);
        
        sell[1]=Math.max(0,prices[1]-prices[0]);
        
        for(int i=2;i<n;i++){
            buy[i]=Math.max(buy[i-1], sell[i-2]-prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
        }
        
        return sell[n-1];
        
    }
}

// Method 2: O(1) space
Let b1, b0 represent buy[i - 2], buy[i - 1], buy[i]
Let s2, s1, s0 represent sell[i - 2], sell[i - 1], sell[i]

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        
        int n = prices.length;
        int b0=-prices[0], b1=b0;
        int s0=0, s1=0, s2=0;
        
        for(int i=1;i<n;i++){
            b0=Math.max(b1, s2-prices[i]);
            s0 = Math.max(s1, b1+prices[i]);
            b1=b0;
            s2=s1;
            s1=s0;
        }
        
        return s0;
    }
}
