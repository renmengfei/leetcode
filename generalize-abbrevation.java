public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<String>();
        helper(result, word, 0, "", 0);

        return result;
    }
    
    public void helper(List<String> result, String word, int level, String path, int count){
        if(level==word.length()){
            if(count > 0) path += count;
            result.add(path);
        }
         else{
	    // char换，count++
            helper(result, word, level + 1, path, count + 1);
	    // char不换,注意count>0时，需要加入path
            helper(result, word, level + 1, path + (count>0 ? count : "") + word.charAt(level), 0);
        }
    }
}
