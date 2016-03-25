/** A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

For example,
Given n = 2, return ["11","69","88","96"].
*/

//难点，需要handle最外层是0+mid+0的case
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper( n, n);
    }
    
    public List<String> helper(int n, int level){
        List<String> result = new ArrayList<String>();
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        
        List<String> sublist = helper(n-2, level);
        for(int i=0;i<sublist.size();i++){
            String mid = sublist.get(i);
            if(n!=level){
                result.add("0"+mid+"0");
            }
            result.add("1"+mid+"1");
            result.add("8"+mid+"8");
            result.add("6"+mid+"9");
            result.add("9"+mid+"6");
        }
        return result;
    }
}


//Method 2: iteration
public List<String> findStrobogrammatic(int n) {

        List<String> prev = new ArrayList<String>();
        if(n % 2 == 0){
            prev.add("");
        } else{
            prev.add("0");
            prev.add("1");
            prev.add("8");
        }

        for(int i = 0; i <n/2; i++){
            List<String> res = new ArrayList<String>();
            for(int j = 0; j < prev.size(); j++){
                String cur = prev.get(j);
                if(i+1 != n/2){
                    res.add("0" + cur + "0");
                }
                res.add("1" + cur + "1");
                res.add("6" + cur + "9");
                res.add("8" + cur + "8");
                res.add("9" + cur + "6");
            }
            prev = res;
        }
        return prev;

    }
