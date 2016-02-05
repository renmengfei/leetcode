//这种方法只能用于prime, powerofSix就不行，不然2就true了
public class Solution {
    public boolean isPowerOfThree(int n) {
        int base = (int)(Math.log(Integer.MAX_VALUE)/Math.log(3));
        int maxthreepower = (int)Math.pow(3, base);
        return n>0 && maxthreepower%n==0;
    }
}
