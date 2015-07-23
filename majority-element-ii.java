// count1,2的初始值必须是0，是1的话，一开始的if(count1==0)就不满足了,例子[1]
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int major1 = 0, major2 = 1;
        int count1 = 0, count2 = 0;
        
        // (1)
        for(int i=0;i<nums.length;i++){
            if(nums[i]==major1){
                count1++;
            }
            else if(nums[i]==major2){
                count2++;
            }
            else if(count1==0){
                major1=nums[i];
                count1=1;
            }
            else if(count2==0){
                major2=nums[i];
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
        }
        
        // (2) verify major1,2 
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]== major1) count1++;
	    // else很重要，万一选得major1,major2初始值一样，就会出现重复,例子[0,0,0]
            else if(nums[i]== major2) count2++;
        }
        
        if(count1>nums.length/3) result.add(major1);
        if(count2>nums.length/3) result.add(major2);
        return result;
    }
}
