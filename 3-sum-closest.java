// O(n^2)不能更快
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
	//bug: result不能随便给初值，否则，初值可能就是最接近结果
        int result = num[0]+num[1]+num[2];
        for(int one = 0;one<num.length-2;one++){
            int two = one+1;
            int three = num.length-1;
            while(two<three){
                int sum = num[one]+num[two]+num[three];
                if(sum==target) return sum;
                if(sum>target) three--;
                if(sum<target) two++;
                if(Math.abs(target-sum)<Math.abs(target-result)){
                    result = sum;
                }
                
            }
        }
        return result;
    }
}
