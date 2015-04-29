//考察comparator，注意bug ［0，0］
public class Solution {
    public String largestNumber(int[] nums) {
        if(nums ==null || nums.length==0) return "";
        // step 1: to string array
        String[] Snum = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            Snum[i] = nums[i]+"";
        }
        
        // step 2: comparator, ascending
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                String s1 = str1+str2;
                String s2 = str2+str1;
                return s1.compareTo(s2);
            }
        };
        
        // step 3: sort
        Arrays.sort(Snum,comp);
        //bug [0,0] => "00"
        if(Snum[Snum.length-1].charAt(0)=='0') return "0";
        
        StringBuilder sb = new StringBuilder();

        for(String s: Snum) sb.insert(0, s);
        return sb.toString();
    }
}
