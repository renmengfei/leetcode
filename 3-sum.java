public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for(int one=0;one<num.length;one++){
	    // bug!!! 为了去掉重复
            if(one==0 || (one>0 && num[one]!=num[one-1])){
                int two=one+1;
                int three=num.length-1;
                while(two<three){
                    int sum = num[two]+num[three];
                    if(sum==-num[one]){
                        result.add(Arrays.asList(num[one],num[two],num[three]));
			// bug: 去掉重复
                        while (two < three && num[two] == num[two+1]) two++;//skip duplicates
                        while (two < three && num[three] == num[three-1]) three--;
                        two++;
                        three--;
                    }
                    else if(sum<-num[one]) two++;
                    else three--;
                }
            }
        }
        return result;
    }
}
