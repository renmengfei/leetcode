This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

Note:
You may assume word1 and word2 are both in the list.

//跟shortest-word-distance-1类似，只是word2==word1时，用word2的旧值代替word1
public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int first = -1, second = -1;
        int result = Integer.MAX_VALUE;
        
        for(int i=0;i<words.length; i++){
            if(words[i].equals(word1)){
                first = i;
            }
            if(words[i].equals(word2)){
                if(words[i].equals(word1)){
                    first = second;
                }
                second = i;
            }
            
            if(first!=-1 && second !=-1){
                result = Math.min(result, Math.abs(first-second));
            }
        }
        return result;
    }
}

