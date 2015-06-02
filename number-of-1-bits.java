public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
	//bug: unsigned, cannot use while(n!=0) n&1, n>>=1 除非使用>>>
        for(int i=0;i<32;i++){
            if((n & (1<<i))!=0) result++;
        }
        return result;
    }
}


//Method 2: 减少循环次数 每次找rightmost 1
// lowbit = c-c&(c-1)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while(n!=0)
        {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
