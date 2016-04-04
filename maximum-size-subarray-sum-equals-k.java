public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0, result = 0;
        
        for(int i=0;i<nums.length; i++){
            sum+=nums[i];
            if(sum==k){
                result = Math.max(result, i+1);
            }
            else if(map.containsKey(sum-k)){
                // i-j就可以，因为[j+1, i] = k
                result = Math.max(result, i-map.get(sum-k));
            }
	    //if很重要，如果出现重复的sum了，用小的index，让subarray更长,example(1,0,-1)
            if(!map.containsKey(sum))map.put(sum, i);
        }
        
        return result;
    }
}
