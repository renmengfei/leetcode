// Method 1: 图的bfs，注意remove，防止多次visit
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
         wordList.add(endWord);
         
         Queue<String> q = new LinkedList<String>();
         addNeighbor(beginWord, wordList, q);
         
         int dist = 2;
         while(!q.isEmpty()){
             int size = q.size();
             for(int i=0;i<size; ++i){
                 String cur = q.poll();
                 if(cur.equals(endWord)) return dist;
                 addNeighbor(cur, wordList, q);
             }
             dist++;
         }
         
         return 0;
    }
    
    public void addNeighbor(String word, Set<String> wordList, Queue<String> q){
        wordList.remove(word);
        char[] words = word.toCharArray();
        for(int i=0;i<word.length(); i++){
            char letter = words[i];
            for(char c='a';c<='z';c++){
                
                if(c==letter) continue;
                words[i]=c;
                String tmp = new String(words);
                if(wordList.contains(tmp)){
                    q.add(tmp);
                    wordList.remove(tmp);
                }
            }
            words[i]=letter;
        }
    }
}

// Method 2:双向发展
//beginset, endset, 一开始只有一个word，然后轮流找neighbour，如果beginset里找到endset，说明merge了；如果endset里找到beginset，也一样
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();
    
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            //swap的目的是，beginset，endset轮流找neighbour
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
    
            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
    
                for (int i = 0; i < chs.length; i++) {
                    char old = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        
                        chs[i] = c;
                        String target = String.valueOf(chs);
    
                        if (endSet.contains(target)) {
                            return len + 1;
                        }
    
                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                    }
                    chs[i] = old;
                }
            }
    
            beginSet = temp;
            len++;
        }
    
        return 0;
    }
}

