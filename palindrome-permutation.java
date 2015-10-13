Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.



public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        
        for(char c: s.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
            }
            else{
                set.remove(c);
            }
        }
        
        return set.size()<=1;
    }
}
