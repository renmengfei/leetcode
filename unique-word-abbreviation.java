An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true


//注意, no other word, 如果有同样的word，而且unique，那么也算
public class ValidWordAbbr {
    private Map<String, String> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, String>();
        
        for(String word: dictionary){
            String tmp = toAbbr(word);
            if(map.containsKey(tmp)){
		// 有重复【“a”，“a” 】isUnque("a")=true
		 if(!map.get(key).equals(str)){
                	map.put(tmp, "");
		 }
            }
            else{
                map.put(tmp, word);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = toAbbr(word);
        if(!map.containsKey(abbr)) return true;
        return map.get(abbr).equals(word);
        
    }
    
    // output could be null
    public String toAbbr(String s){
        if(s==null) return null;
        if(s.length()<=2) return s;
        
        return s.charAt(0) + Integer.toString(s.length()-2) + s.charAt(s.length()-1);
    }
}
