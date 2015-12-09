// sum & sum补码，去除最后一位1
// 将nums分成两份，一份这一位是1，一份这一位是0

public class Solution {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        
        for(int n: nums){
            sum^=n;
        }
        
        // sum = a^b;
        sum &=-sum;
        
        int[] result = new int[2];
        for(int n: nums){
            if((n&sum)>0){
                result[0]^=n;
            }
            else result[1]^=n;
        }
        
        return result;
        
        
    }
}
