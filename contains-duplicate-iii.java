// Method 1: O(Nlogk)  treeSet实现了红黑树, set中永远只存k个value，类似sliding window
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        TreeSet<Integer> values = new TreeSet<Integer>();
        
        
        for(int i=0; i<nums.length; i++){
            Integer floor = values.floor(nums[i]+t);
            Integer ceil = values.ceiling(nums[i]-t);
            
            if(floor!=null && floor>=nums[i] || ceil!=null && ceil<=nums[i]) return true;
            
            if(values.size()>=k){
                values.remove(nums[i-k]);
            }
            
            values.add(nums[i]);
        }
        
        return false;
        
    }
}

// Method 2: bucket sort O(N)
//桶的大小是t，防止t=0的case，所以用t+1 
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<1 || t<0) return false;
        Map<Long, Long> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            long num = (long)nums[i]-Integer.MIN_VALUE;
            long bucket = num/((long)t+1);
            if(map.containsKey(bucket) || map.containsKey(bucket-1) && num-map.get(bucket-1)<=t || map.containsKey(bucket+1) && map.get(bucket+1)-num <=t) return true;
            
            if(map.entrySet().size()>=k){
                long lastbucket = ((long) nums[i-k]-Integer.MIN_VALUE) / ((long)t+1);
                map.remove(lastbucket);
            }
            
            map.put(bucket, num);
        }
        
        return false;
    }
}
