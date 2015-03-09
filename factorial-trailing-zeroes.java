// Method 1:往上加
public class Solution {
    public int trailingZeroes(int n) {
        int res=0;
        for(int i=1;Math.pow(5,i)<=n;i++){
            res+=n/Math.pow(5,i);
        }
        return res;
    }
}

// Method 2: 往下减，比较难理解,一个数字中包含多个5，如25，所以需要循环两次
public class Solution {
    public int trailingZeroes(int n) {
        int res=0;
        while(n>0){
            n/=5;
            res+=n;
        }
        return res;
    }
}
