public class Solution {
    public List<Integer> grayCode(int n) {
      List<Integer> result = new ArrayList<Integer>();
      result.add(0);
      
      for(int i=0;i<n;i++){
          int radix=1<<i;
          int len = result.size()-1;
          for(int j=len;j>=0;j--){
              int tmp=result.get(j)+radix;
              result.add(tmp);
          }
      }
      return result;
    }
}
