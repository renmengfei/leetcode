public class Solution {
    public int divide(int dividend, int divisor) {
        // step 1: handle sign
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        // 换正负号时，可能会overflow，比如Integer.MIN_VALUE的abs会溢出
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        // step 2: corner case 
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor)) return 0;
        
        long lans = ldivide(ldividend, ldivisor);
        // step 3: 得到结果后，再处理overflow
        int ans;
        if (lans > Integer.MAX_VALUE){ //Handle overflow.
            ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }
    
    // 15除3，先按3，3<<1, 3<<2，得到12后，剩下的recursion
    private long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
    
        long sum = ldivisor;
        long multiple = 1;
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
