/*
 * Reverse digits of an integer.
 */

// (1) Integer's last digit is 0. doesn't matter
// (2) Overflow, should use long to store result

public class Solution {
    public int reverse(int x) {
        int sign = 1;
        if(x<0) {
            sign = -1;
            x*=-1;
        }
        long ret = 0;
        while(x>0){
            int digit = x%10;
            x/=10;
            ret = ret*10+digit;
        }
        ret*=sign;
        if(ret>0 && ret>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(ret<0 && ret<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)ret;
        
    }
}
