public class Solution {
//跟best timei to buy stock是一模一样的问题
sum[i]=a[0]+a[1]+...+a[i];
sum[j]=a[0]+...+a[i]+...a[j];

找最大
可以拓展到找k堆subarray的sum最大

// minimum subarray
// 取-1,再用max做

    // Method 1:  O(N)
    public int maxSubArray(int[] A) {
        int result = Integer.MIN_VALUE;
        int max_here = 0;
        
        for(int i=0;i<A.length;i++){
            max_here=Math.max(max_here+A[i],A[i]);
            result = Math.max(result, max_here);
        }
        return result;
    }    

    // Method 2: divide and conquer T(n)=2T(n/2)+O(n)  => O(nLogn)
    public int maxSubArray(int[] A){
        return divide(A, 0, A.length-1);
    }

    public int divide(int[] A, int start, int end){
        if(start>end) return Integer.MIN_VALUE;
        if(start==end) return A[start];
        int mid = (start+end)/2;
        int maxleft = divide(A, start, mid-1);
        int maxright = divide(A, mid+1, end);

        // calculate mid part
        int midleft = Integer.MIN_VALUE;
        int leftsum = 0;
        int midright = Integer.MIN_VALUE;
        int rightsum = 0;
        for(int i=mid-1;i>=start;i--){
            leftsum+=A[i];
            midleft = Math.max(midleft, leftsum);
        }
        for(int i=mid+1;i<=end;i++){
            rightsum+=A[i];
            midright = Math.max(midright, rightsum);
        }

        int maxmid = A[mid]+Math.max(midleft,0)+Math.max(midright,0);
        return Math.max(Math.max(maxleft, maxright), maxmid);
    }
}



