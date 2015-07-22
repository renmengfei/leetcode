// 拓展，DP一定要k次交易
// f[i][j] 前i天进行第j次交易，得到的最大收益
// init: f[i][0]=0; f[0][j]=MIN_VALUE;
// profit(k+1,i)在k＋1到i，只进行一次交易的最大值，使用best-ii.java
// transfer: f[i][j]= f[k][j-1] + profit(k+1,i),  k在[0,i-1]之间
// return f[n][k]

//DP转移不好理解https://gist.github.com/ElninoFong/d08051d98e634991cd93
/*
global[i][j]=max(local[i][j],global[i-1][j])，
也就是去当前局部最好的，和过往全局最好的中大的那个（因为最后一次交易如果包含当前天一定在局部最好的里面，
否则一定在过往全局最优的里面）。

local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)，
也就是看两个量，第一个是全局到i-1天进行j-1次交易，然后加上今天的交易，
如果今天是赚钱的话（也就是前面只要j-1次交易，最后一次交易取当前天），

局部（在第i天交易后，总共交易了j次） =  max{情况2，情况1}

情况1：在第i-1天时，恰好已经交易了j次（local[i-1][j]），那么如果i-1天到i天再交易一次：
即在第i-1天买入，第i天卖出（diff），则这不并不会增加交易次数！
【例如我在第一天买入，第二天卖出；然后第二天又买入，第三天再卖出的行为  和   第一天买入，
第三天卖出  的效果是一样的，其实只进行了一次交易！因为有连续性】

情况2：第i-1天后，共交易了j-1次（global[i-1][j-1]），因此为了满足“第i天过后共进行了j次交易，
且第i天必须进行交易”的条件：我们可以选择1：在第i-1天买入，然后再第i天卖出（diff），
或者选择在第i天买入，然后同样在第i天卖出（收益为0）。
*/

// 2D DP
public class Solution {
    public int maxProfit(int[] prices) {
        return max(prices, 2);
    }
    
    public int max(int[] prices, int k) {       // k: k times transactions
        int len = prices.length;
        if(len == 0) {
            return 0;
        }
        int[][] local = new int[len][k+1];      // local[i][j]: max profit till i day, j transactions,
                                                // where there is transaction happening on i day
        int[][] global = new int[len][k+1];     // global[i][j]: max profit across i days, j transactions
        for(int i=1; i<len; i++) {
            int diff = prices[i] - prices[i-1];
            for(int j=1; j<=k; j++) {
                local[i][j] = Math.max(global[i-1][j-1]+Math.max(diff,0), local[i-1][j]+diff);
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[len-1][k];
    }
}

//上面的解法简化 leetcode at most k次交易
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



// 1D DP
public int maxProfit(int k, int[] prices) {
	if (prices.length < 2 || k <= 0)
		return 0;
 
	int[] local = new int[k + 1];
	int[] global = new int[k + 1];
 
	for (int i = 0; i < prices.length - 1; i++) {
		int diff = prices[i + 1] - prices[i];
		for (int j = k; j >= 1; j--) {
			local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
			global[j] = Math.max(local[j], global[j]);
		}
	}
 
	return global[k];
}
