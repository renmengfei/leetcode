//分词问题DP
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
	// dp[i]  [0,i)是否可以被分词,用len＋1，因为substring不是封闭的
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1; i <= s.length(); i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&wordDict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
