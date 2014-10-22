public class Solution {
    //Method 1: switch 
    public int removeElement(int[] A, int elem) {
      int len = A.length;
      int count = 0;
      
      for(int i=0;i<len;i++){
          if(A[i]==elem){
              A[i--]=A[--len]; // backtrace
          }
      }
      return len;
      
    }
    
    //Method 2: overwrite
    public int removeElement(int[] A, int elem) {
        int count = 0;
        int i = 0;
        
        while(i<A.length){
            if(A[i]!=elem) A[count++]=A[i];
            i++;
        }
        return count;
    }
    
}
