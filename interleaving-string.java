public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null || s1.isEmpty()) return s3.equals(s2);
        if(s2==null || s2.isEmpty()) return s3.equals(s1);
        if(s3.length()!=s1.length()+s2.length()) return false;
                
        int n = s1.length();
        int m = s2.length();
        boolean[][] dp = new boolean[n+1][m+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                }
                else if(i==0){
                    dp[i][j] = dp[i][j-1] && s3.charAt(i+j-1)==s2.charAt(j-1);
                }
                else if(j==0){
                    dp[i][j]=dp[i-1][j] && s3.charAt(i+j-1)==s1.charAt(i-1);
                }
                else{
                    dp[i][j] = (dp[i][j-1] && s3.charAt(i+j-1)==s2.charAt(j-1) ) || (dp[i-1][j] && s3.charAt(i+j-1)==s1.charAt(i-1));
                }
            }
        }
        
        return dp[n][m];
        
    }
}
