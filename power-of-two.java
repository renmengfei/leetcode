// Method 1: initial thought
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        while(n%2==0) n/=2;
        
        if(n==1) return true;
        return false;
        
    }
}

// Method 2: bit manipulation
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return ((n & (n-1))==0 && n>0);
    }
}
