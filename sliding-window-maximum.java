// Method 1： initial idea
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n==0){
            return new int[0];
        }
       
        if(n<k){
            int[] tmp = new int[1];
            tmp[0] = max(nums, 0, n-1);
            return tmp;
        }
        
        int[] result = new int[n-k+1];
        int start = 0, end=k-1;
        
        int index = 0;
        while(end<n){
            result[index++]= max(nums, start++, end++);
        }
        return result;
    }
    
    public int max(int[]nums, int start, int end){
        int result = Integer.MIN_VALUE;
        
        for(int i=start; i<=end; i++){
            result = Math.max(result, nums[i]);
        }
        return result;
    }
}

// Method 2: dequeue
// queue中存放的是index
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length==0){
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n-k+1];
        
        Deque<Integer> q = new ArrayDeque<Integer>();
        int index = 0;
        for(int i=0;i<n;i++){
            while(!q.isEmpty() && q.peekFirst()<i-k+1){
                q.pollFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }
 	    // deque用offer比add好
            q.offer(i);
            if(i>=k-1){
                result[index++]= nums[q.peekFirst()];
            }
        }
        return result;
    }
}
