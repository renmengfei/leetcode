public class Solution {
    public void nextPermutation(int[] num) {
        int n = num.length;

        for(int i = n-1;i>0;i--){
            // step 1:  index i是right most第一个nonascending的点
            if(num[i]>num[i-1]){
                int j;
                //step 2: 从后向前，找第一个比(i-1)大的数，交换！
                for(j=n-1;j>i-1;j--){
                    if(num[j]>num[i-1]) break;
                }
		
                swap(num, i-1,j);
                // step 3: reverse
		reverse(num, i, n-1);// reverse is important
                return;
            }
        }

        reverse(num,0, n-1);//bug,忘记最后反过来了
    }
    
    
    public void reverse(int[] num, int start, int end){
       while(start<end){
            int tmp=num[start];
            swap(num,start++,end--);
        }
    }
    
    public void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i]=num[j];
        num[j]=tmp;
    }
    
}
