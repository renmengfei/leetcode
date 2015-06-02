// 拓展，DP一定要k次交易
// f[i][j] 前i天进行第j次交易，得到的最大收益
// init: f[i][0]=0; f[0][j]=MIN_VALUE;
// profit(k+1,i)在k＋1到i，只进行一次交易的最大值，使用best-ii.java
// transfer: f[i][j]= f[k][j-1] + profit(k+1,i),  k在[0,i-1]之间
// return f[n][k]

// leetcode at most k次交易
// tmpMax means the maximum profit of just doing at most i-1 transactions, using at most first j-1 prices, and buying the stock at price[j] - this is used for the next loop.
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        int[][] t = new int[k + 1][len];
        // init: t[0][j]=0
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }


    // best-ii.
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
