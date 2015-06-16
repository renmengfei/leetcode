//这个方法可以避免n=Integer.MIN_VALUE时的overflow
// O(logN)
public class Solution {
    public double pow(double x, int n) {
        if(x==0) return 1;
        if(n==0) return 1;
        double half=pow(x,n/2);
        if(n%2==0) return half*half;
        else if(n>0) return half*half*x;
        else return half*half/x;
    }
}
