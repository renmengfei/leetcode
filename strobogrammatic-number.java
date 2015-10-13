A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.


// Method 1:最直接的想法
public class Solution {
    public boolean isStrobogrammatic(String num) {
        HashMap<Character,Character> map = new HashMap<Character, Character>();
        map.put('6','9');
        map.put('9','6');
        map.put('1','1');
        map.put('8','8');
        map.put('0','0');
        
        int start = 0, end = num.length()-1;
        
        while(start<=end){
            if(!map.containsKey(num.charAt(start))) return false;
            if(map.get(num.charAt(start))!=num.charAt(end)) return false;
            start++;
            end--;
        }
        
        return true;
    }
}

//Method2: 不用map存
public class Solution {
    public boolean isStrobogrammatic(String num) {
        for (int i=0, j=num.length()-1; i <= j; i++, j--)
            if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)))
                return false;
        return true;
    }
}
