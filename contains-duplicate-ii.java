public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length<2){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int prev = map.get(nums[i]);
                if(i-prev<=k){
                    return true;
                }
               
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
