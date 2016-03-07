// Method 1:

      public static int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.startsWith("0")) return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            
           int first = Integer.parseInt(s.substring(i-2,i));
           int prev = (first<=26 && first>=10)? dp[i-2]:0;
           int plus = Integer.parseInt(s.substring(i-1,i))==0?0: dp[i-1];
           
           dp[i] = prev + plus;
                   
        }

        return dp[n];
    }

// Method 2: 简化，不需要dp[n]，两个数就能存储
    public static int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.startsWith("0")) return 0;

        int r1=1, r2=1;

        for (int i = 2; i <= n; i++) {
            
           int first = Integer.parseInt(s.substring(i-2,i));
           int prev = (first<=26 && first>=10)? r2:0;
           int plus = Integer.parseInt(s.substring(i-1,i))==0?0: r1;
           
           r2=r1;
           r1 = prev+plus;
                   
        }

        return r1;
    }
