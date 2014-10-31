public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        int[] res = new int[rowIndex+1];
        res[0]=1;

        for(int i=1;i<=rowIndex;i++){//容易bug
            for(int j = i-1;j>0;j--){//用滚动数组记录，所以要从后向前，否则，res[j-1]被改写了，res[j]>就没法算了
                res[j]=res[j]+res[j-1];
            }
            res[i]=1;
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<res.length;i++){
            result.add(res[i]);
        }
        return result;
    }
}
