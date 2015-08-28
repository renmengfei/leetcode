// Method 1: O(N) 最大最小
public class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for(int i=1;i<A.length;i++){
            int tmp = max;
	    // bug: 比较3个数，比较A[i],防止0的出现，比如[0,2]
            max = Math.max(Math.max(A[i]*max, A[i]*min), A[i]);
            min = Math.min(Math.min(A[i]*tmp, A[i]*min), A[i]);
            result = Math.max(result, max);
        }
        return result;
    }
}

// 简洁一点的method 1
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max=nums[0], min=nums[0], result = nums[0];
        
        for(int i=1; i< nums.length; i++){
            if(nums[i]<0){
                int tmp = max;
                max = min;
                min = tmp;
            }
            
            max = Math.max(max*nums[i], nums[i]);
            min = Math.min(min*nums[i], nums[i]);
            
            result = Math.max(result, max);
            
        }
        return result;
        
    }
}

// Method 2: 
public class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int front = 1, back = 1, result = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            front *= A[i];
            back *= A[A.length-1-i];
	    // bug: 必须先算result，而且需要比较result， front， back。example[0]
            result = Math.max(result,Math.max(front, back));
            front = front==0? 1: front;
            back = back==0?1:back;
        }
        return result;
    }
}
