public class Solution {
    public boolean isPalindrome(int x) {
        //reverse是一种方法，但需要O(n)空间,此题可以in place

        if(x<0) return false;
        int num = 1;
        //bug: 必须除以10，而不是1，不然x<10情况，num＝10，不成立
        while(x/num>=10){
            num*=10;
        }

        while(x!=0){
            int high = x/num;
            int low = x%10;
            if(high!=low) return false;
            else{
                x = (x%num)/10;
                num/=100;//bug
            }
        }
        return true;
    }
}
