// 对于two sequence dp，0代表第0个位置（空串），所以size＝n+1
//无论T的字符与S的字符是否匹配，dp[i][j] = dp[i][j - 1].就是说，假设S已经匹配了j - 1个字符，得到匹配个数为dp[i][j - 1].现在无论S[j]是不是和T[i]匹配，匹配的个数至少是dp[i][j - 1]。除此之外，当S[j]和T[i]相等时，我们可以让S[j]和T[i]匹配，然后让S[j - 1]和T[i - 1]去匹配
public class Solution {
    public int numDistinct(String S, String T) {
        int sl = S.length();
        int tl = T.length();

        int [][] dp = new int[tl+1][sl+1];
        
        for(int i=0;i<sl;i++){
            dp[0][i]=1;
        }
        
        for(int i=1;i<=tl;i++){
            for(int j=1;j<=sl;j++){
                dp[i][j] = dp[i][j - 1];  
                if (T.charAt(i - 1) == S.charAt(j - 1)) {  
                    dp[i][j] += dp[i - 1][j - 1];  
                }
            }
        }
        
        return dp[tl][sl];
    }
}
