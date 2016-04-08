// greedy,跟jump game很像。核心是找max边界，只有在不得已的时候，才+1

// miss是开区间[0,miss),
public class Solution {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int result = 0;
        int i=0;
        
        // miss是开区间，所以有等号
        while(miss<=n){
            if(i<nums.length && nums[i]<=miss){
                miss+=nums[i++];
            }
            else{
                //当下一个数比miss大，那么久不能组成下一个数了，此时只能add一个value=miss的数，而且i不加1
                miss+=miss;
                result++;
                
            }
        }
        
        return result;
    }
}
