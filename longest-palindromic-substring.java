//Method 1: easy way O(N^2)
public class Solution {
    public String longestPalindrome(String s) {
        String result="";
        int n=s.length();
        //odd
        for(int i=0;i<n;i++){
            String tmp = expandCenter(s, i, i);
            if(tmp.length()>result.length()) result = tmp;
        }
        //even
        for(int i=0;i<n-1;i++){
            String tmp = expandCenter(s, i, i+1);
            if(tmp.length()>result.length()) result = tmp;
        }
        
        return result;
    }
    
    public String expandCenter(String s, int start, int end){
        while(start>=0 && end<s.length()){
            if(s.charAt(start)!=s.charAt(end)) break;
            start--;
            end++;
        }
        return s.substring(start+1,end);
        
    }
}

// Method 2: DP, time limit
public class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                dp[i][j] = (s.charAt(i)==s.charAt(j)) && (j-i<3||dp[i+1][j-1]);
                
                if(dp[i][j] && j-i+1 >result.length()){
                    result = s.substring(i, j+1);
                }
            }
        }
        return result;
        
        
    }
}

// Method 3:  其实跟method1一样，只是更加简易，不用讨论奇偶的情况
public class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==0) return "";
        if(s.length()==1) return s;
        
        int start = 0, max_len=0;
        
        for(int i=0;i<s.length();){
            //长度不够了
            if(s.length()-i < max_len/2) break;
            
            int j=i, k=i;
            // j,k是相同的start, end点
            while(k<s.length()-1 && s.charAt(k)==s.charAt(k+1)) k++;
            i=k+1;
            
            while(j>0 && k<s.length()-1 && s.charAt(j-1)==s.charAt(k+1)){
                j--;
                k++;
            }
            if(k-j+1>max_len){
                max_len = k-j+1;
                start = j;
            }
        }
        
        return s.substring(start, max_len+start);
    }
}


