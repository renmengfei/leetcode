public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if(len<3) return len;

        //两个指针，一个快一个慢 for sorted array
        int cur =1;
        for(int fast=2;fast<len;fast++){
            if(!(A[fast]==A[cur]&&A[fast]==A[cur-1])){
                A[++cur]=A[fast];
            }
        }
        return cur+1;


    }
}

