// O(log(min(m,n)))
// https://leetcode.com/discuss/15790/share-my-o-log-min-m-n-solution-with-explanation

   public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        
        if(m>n) return findMedianSortedArrays(B,A);
        
        int half = (n+m+1)/2;
        
        int l=0, r = m;
        while(l<=r){
            int i = (l+r)/2;
            int j = half-i;
            if(i<m && j>0 && B[j-1]>A[i]){
                l = i+1;
            }
            else if(i>0 && j<n && A[i-1]>B[j]){
                r = i-1;
            }
            else{
                int num1=0;
                if(i==0){
                    num1 = B[j-1];
                }
                else if(j==0){
                    num1 = A[i-1];
                }
                else{
                    num1 = Math.max(A[i-1], B[j-1]);
                }
                
                if((m+n)%2==1) return num1;
                
                int num2=0;
                if(i==m){
                    num2=B[j];
                }
                else if(j==n){
                    num2 = A[i];
                }
                else{
                    num2 = Math.min(A[i], B[j]);
                }
                return (num1+num2)/2.0;
            }
        }
        return 0;
        
    }


