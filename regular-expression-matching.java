// Method 1: recursion

public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();
 
        boolean is_same = same(s,p);
        if (p.length()>1 && '*' == p.charAt(1)){
		boolean a = isMatch(s, p.substring(2));// .* match empty
		boolean b = is_same && isMatch(s.substring(1), p); // a*
		return a || b;
        else if(p.length()>1 && p.charAt(1)=='+'){
            boolean a = same && isMatch(s.substring(1), p);
            boolean b = same && isMatch(s.substring(1), p.substring(2));
            return a||b;
           
        }
        else
            return  is_same && isMatch(s.substring(1), p.substring(1));
    }
    
    
    public boolean same(String s, String p){
        return !s.isEmpty() && (s.charAt(0) == p.charAt(0) || '.' == p.charAt(0));
    }
}

// Method 2: DP
    public boolean isMatch(String s, String p) {
          /*
            'match' below including .
        f(i,j) means s where s.len=i matches p where p.len=j
        f(i,j) =
            if (p_j-1 != * ) f(i-1, j-1) and s_i-1 matches p_j-1
            if (p_j-1 == * )
                * matches zero times: f(i,j-2)
                or * matches at least one time: f(i-1,j) and s_i-1 matches p_j-2
         */
        if (!p.isEmpty() && p.charAt(0) == '*') {
            return false;   // invalid p
        }
    
        boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
    
        // initialize f(0,0)
        f[0][0] = true;
    
        // f(k,0) and f(0,2k-1) where k>=1 are false by default
    
        // initialize f(0,2k) where p_2k-1 = * for any k>=1
        for (int j = 1; j < p.length(); j+=2) {
            if (p.charAt(j) == '*') {
                f[0][j+1] = f[0][j-1];
            }
        }
    
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {
                    f[i][j] = f[i - 1][j - 1] && isCharMatch(s.charAt(i - 1), p.charAt(j - 1));
                } else {
                    f[i][j] = f[i][j - 2] || f[i - 1][j] && isCharMatch(s.charAt(i - 1), p.charAt(j - 2));
                }
            }
        }
    
        return f[s.length()][p.length()];
    }

    // no * in p
    private boolean isCharMatch(char s, char p) {
        return p == '.' || s == p;
    }
