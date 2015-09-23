public class Solution {
    //O(N) overwrite
    public int removeDuplicates(int[] nums) {
        if(nums.length<2) return nums.length;
        int end = 0;
        int ptr = 1;
        
        for(;ptr<nums.length;ptr++){
            if(nums[ptr]!=nums[end]){
                nums[++end]=nums[ptr];
            }
            
        }   
        return end+1;
    }
}
