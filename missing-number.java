// Method 1: 类似singel number
public class Solution {
    public int missingNumber(int[] nums) {
        int result = nums.length;
        
        for(int i=0;i<nums.length;i++){
            result^=nums[i];
            result^=i;
        }
        
        return result;
    }
}

// Method 2:用sum，bug：n很大的时候会overflow
public class Solution {
    public int missingNumber(int[] nums) {
        int sum =0;
        for(int n:nums){
            sum+=n;
        }
        
        return nums.length*(nums.length+1)/2-sum;
    }
}
