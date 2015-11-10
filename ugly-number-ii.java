//Method 1: priority queue
//难点，有重复，要去掉重复, 2*3, 3*2
// 1*2, 2*2, 3*2 
// 1*3, 2*3, 3*3
// 1*5, 2*5, 3*5
// queue需要用long，以免overflow
public class Solution {
    public int nthUglyNumber(int n) {
        if(n<=0) return 0;
        
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1l);
        
        long result = 0;
        for(int i=1;i<=n;i++){
            result = queue.poll();
            while(!queue.isEmpty() && queue.peek()==result) queue.poll();
            queue.add(result*2);
            queue.add(result*3);
            queue.add(result*5);
        }
        return (int)result;
    }
}

// Method 2: DP
public class Solution {
    public int nthUglyNumber(int n) {
        if(n<=0) return 0;
        
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        
        for(int i=1;i<n;i++){
            int min = Math.min(factor2, Math.min(factor3,factor5));
            ugly[i] = min;
            
            if(factor2==min){
                factor2 = 2*ugly[++index2];
            }
            if(factor3==min){
                factor3 = 3*ugly[++index3];
            }
            if(factor5==min){
                factor5 = 5*ugly[++index5];
            }
        }
        return ugly[n-1];
    }
}
