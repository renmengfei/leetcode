public class Solution {
    //counting sort
    // public void sortColors(int[] A) {
    //     // Note: The Solution object is instantiated only once and is reused by each test case.
    //     int zeros=0, ones=0, twos=0;

    //     for(int i=0;i<A.length;i++){
    //         switch(A[i]){
    //             case 0:{
    //                 zeros++;
    //                 break;
    //             }
    //             case 1:{
    //                 ones++;
    //                 break;
    //             }
    //             case 2:{
    //                 twos++;
    //                 break;
    //             }
    //             default: break;
    //         }
    //     }//end for

    //     for(int i=0;i<zeros;i++){
    //         A[i]=0;
    //     }
    //     for(int i=0;i<ones;i++){
    //         A[zeros+i]=1;
    //     }
    //     for(int i=0;i<twos;i++){
    //         A[zeros+ones+i]=2;
    //     }
    // }

    public void sortColors(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = A.length;
        int r=0,w=0,b=n-1;
        while(w<=b) {
            if(A[w]==0){
               swap(A,r,w);
	       r++;
               w++;
            }
         else if(A[w]==2){
              swap(A,b,w);
              b--;
         }
         else
              w++;
        }
    }

    public void swap(int[] A, int a, int b){
        int tmp = A[a];
        A[a]=A[b];
        A[b]=tmp;
    }
}
