// Method 1: initial thought O(NM) time, O(NM) space
// dp[i][j] word1.substring(0,i), word2.substring(0,j)的比较    
public int minDistance(String word1, String word2) {
        if(word1==null||word1.length()==0) return word2.length();
        if(word2==null||word2.length()==0) return word1.length();
        
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        
        for(int i=0;i<=m;i++){
            dp[0][i] = i;
        }
        
        for(int i=0;i<=n;i++){
            dp[i][0] = i;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int a = dp[i-1][j-1]+(word1.charAt(i-1)==word2.charAt(j-1)?0:1);
                int b = dp[i-1][j]+1;
                int c = dp[i][j-1]+1;
                dp[i,j] =Math.min(Math.min(a,b),c);
            }
        }
        return dp[n][m];
    }

// Method 2: O(n) space
    public int minDistance(String word1, String word2) {
        int opt[] = new int[word2.length()+1];
        // base case
        for(int j = 0;j <= word2.length();j++) opt[j] = j;
        // iteration
        for(int i = 1;i <= word1.length();i++){
            int pre = i, corner = i-1;
            for(int j = 1;j <= word2.length();j++){
                int temp = corner;
                corner = opt[j];
                temp += (word1.charAt(i-1)==word2.charAt(j-1)?0:1); 
                opt[j] = Math.min(temp,Math.min(opt[j],pre)+1);
                pre = opt[j];
            }
            opt[word2.length()] = pre;
        }
        return opt[word2.length()];
    }
