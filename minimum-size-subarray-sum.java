// Two pointers
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0)return 0;       
        int end = 0;
        int start = 0;
        int result = 0;//result的初始值设置很重要，很巧妙
        int sum = 0;
        while(end<nums.length){
            while(sum<s && end<nums.length){
                sum+=nums[end++];
            }
            while(sum>=s && start<end){
		// bug: result==0
                if(result==0 || result>end-start){
                    result = end-start;
                }
                sum-=nums[start++];
            }
        }
        return result;
    }
}
