public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num>0 && (num&(num-1))==0){
            int digit = 0;
            while(num>0){
                num >>= 1;
                digit++;
            }
            
            if(digit%2==1) return true;
        }
        
        return false;
    }
}
