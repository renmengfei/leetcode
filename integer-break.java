//需要想明白，任何一个数，劈成N=3a+2b是最大的，result=3^a*2^b
// n <(n-2)*2,当n>=4时都成立，但考虑到奇偶数，还需要有3。
// 所以n<4单独讨论
// n>=4按dp-2， dp-3来做
public class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(3 * dp[i - 3], 2 * dp[i - 2]);
        }
        return dp[n];
    }
}
