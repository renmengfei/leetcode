//图的bfs，用到两个数据结构，queue(bfs)，hashmap(visited)
//更好的方法，双向拓展，效率是1/K^2

// Method 1: 正常的bfs
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        dict.remove(start);
        int length = 1;
        
        while(!queue.isEmpty()){
            //分层问题，最好用count来for循环
            int count = queue.size();
            for(int i=0;i<count;i++){
                String current = queue.poll();
                //遍历字母
                for (char c = 'a'; c <= 'z'; c++) {
                    //search每一位
                    for (int j=0; j < current.length(); j++) {
                        //跳过当前字母
                        if (c == current.charAt(j)) {
                            continue;
                        }
                        //改变一位
                        String tmp = replace(current, j, c);
                        if (tmp.equals(end)) {
                            return length + 1;
                        }
                        if (dict.contains(tmp)){
                            queue.add(tmp);
                            dict.remove(tmp);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }
    
     private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}


// Method 2:
public int ladderLength(String start, String end, Set<String> dict) {
	Map<String, Integer> distance = new HashMap<String, Integer>();
	distance.put(start, 1);
	Queue<String> q = new LinkedList<>();
	q.add(start);
	while (!q.isEmpty()) {
		String word = q.poll();
		if (word.equals(end))
			break;
		
		for (int i = 0; i < word.length(); i++) {
			char[] newword = word.toCharArray();
			for (int j = 0; j < 26; j++) {
				newword[i] = (char) (j + 'a');
				String tmp = new String(newword);
				if(tmp.equals(end)) return distance.get(word)+1;
				if (dict.contains(tmp) && !distance.containsKey(tmp)) {
					distance.put(tmp, distance.get(word) + 1);
					q.add(tmp);
				}
			}
		}
	}

	Integer result = distance.get(end);
	if (result == null)
		return 0;
	return result;
}

