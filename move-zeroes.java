// Method 1: swap
public class Solution {
    public void moveZeroes(int[] nums) {
        int end = 0;
        int ptr = 0;
        
        for(;ptr<nums.length; ptr++){
            if(nums[ptr]==0) continue;
            else{
                swap(nums, ptr, end);
                end++;
            }
        }
    }
    
    public void swap(int[]nums, int i, int j){
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}

// Method 2: 模板方法
    public void moveZeroes(int[] nums) {
      int end = 0;
      
      for(int i=0;i<nums.length;i++){
          if(nums[i]!=0){
              nums[end++]=nums[i];
          }
      }
      
      while(end!=nums.length){
          nums[end++]=0;
      }
        
    }
