// wildcard 通配符匹配， *匹配的是一段字符串
// regex 正则表达式匹配, *之前的character可以出现0,N次
// Method 1: greedy，最简单的，不需要space， linear time
// startIndex和matchs很重要，p和s的回溯。例子 hi, *?， *没有匹配，?匹配了h
public class Solution {
    public boolean isMatch(String str, String pattern) {
        int s = 0;
        int p = 0;
        int starIndex = -1;
        int matchs = 0;
        
        while(s<str.length()){
            if(p<pattern.length() && (str.charAt(s)==pattern.charAt(p) || pattern.charAt(p)=='?')){
                s++;
                p++;
            }
            else if(p<pattern.length() && pattern.charAt(p)=='*'){
                starIndex = p++;
		// s没有++很重要，因为*可以匹配0个（不匹配）
                matchs = s;
            }
            else if(starIndex!=-1){
                p = starIndex+1;
                s = ++matchs;
            }
            else return false;
        }
        
        // case "", "*"必须判断
        while(p<pattern.length() && pattern.charAt(p)=='*'){
            p++;
        }
        
        return p==pattern.length();
        
    }
}

// Method 2: DP,需要空间
// 等于*比较tricky
// init不太好想
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        // init
        for(int i=1;i<=p.length();i++){
            if(dp[0][i-1] && p.charAt(i-1)=='*') dp[0][i]=true;
        }
        
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
		    // dp[i-1][j] greedy, dp[i][j-1] match empty
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else dp[i][j]=false;
            }
        }
        return dp[s.length()][p.length()];
        
    }
}

// Method 3: DP滚动数组，减少空间
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for (int j = 1; j <= p.length(); j++) {
            boolean pre = dp[0]; // pre代表dp[i-1][j-1]
            dp[0] = dp[0] && p.charAt(j - 1) == '*'; 
            for (int i = 1; i <= s.length(); i++) {
                boolean temp = dp[i]; // record the value before update
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    dp[i] = pre;
                }
                else if(p.charAt(j-1)=='*'){
                    dp[i] = dp[i] || dp[i-1];
                }
                else dp[i] = false;
                pre = temp;
            }
        }
        return dp[s.length()]; 
        
    }
}
