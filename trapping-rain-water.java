// Method 1: initial thought,找到这个点左边中最高点，右边中最高点，短板问题
public class Solution {
    public int trap(int[] A) {
        if(A.length<3) return 0;
        // left_height[i]表示当前点i，它左边最高点
        int[] left_height = new int[A.length];
        int curmaxleft=A[0];
        for(int i=1;i<A.length;i++){
            left_height[i]=curmaxleft;
            curmaxleft = Math.max(curmaxleft,A[i]);
        }

        int result = 0;
        // 从右到左，同样操作。选当前点左右最高点，找短板
        int rightheight = A[A.length-1];
        for(int i=A.length-2;i>=0;i--){
            int standard = Math.min(rightheight,left_height[i]);
            if(A[i]<standard) result+=standard-A[i];
            rightheight = Math.max(rightheight,A[i]);
        }
        return result;
    }
}
// Method 2: 不使用空间,不太好想，类似于短板原理
nt trap(int A[], int n) {
        int left=0; int right=n-1;
        int res=0;
        int maxleft=0, maxright=0;
        while(left<=right){
            if(A[left]<=A[right]){
                if(A[left]>=maxleft) maxleft=A[left];
                else res+=maxleft-A[left];
                left++;
            }
            else{
                if(A[right]>=maxright) maxright= A[right];
                else res+=maxright-A[right];
                right--;
            }
        }
        return res;
    }
