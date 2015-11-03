//任何一个正整数，都可以被分解成一堆质因数的乘积 
public class Solution {
    public boolean isUgly(int num) {
        if(num<=0) return false; // non-positive
        
        while(num%5==0) num/=5;
        while(num%3==0) num/=3;
        while(num%2==0) num/=2;
        
        if(num==1) return true;
        return false;
    }
}
