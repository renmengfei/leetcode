//参考next permutation
public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        int n = num.length;
        Arrays.sort(num);

        result.add(asList(num));
        
        while(true){
            int i;
            for(i=n-1;i>0;i--){
                if(num[i]>num[i-1]) break;
            }
            if(i==0) break;//get the largest permutation
            int j;
            for(j=n-1; j>i-1;j--){
                if(num[j]>num[i-1]) break;
            }
            swap(num,j,i-1);
            reverse(num, i, n-1);
            result.add(asList(num));
        }
        return result;
    }
    
    public List<Integer> asList(int[] num){
        List<Integer> result = new ArrayList<Integer>();
        for (int index = 0; index < num.length; index++) result.add(num[index]);
        return result;
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

