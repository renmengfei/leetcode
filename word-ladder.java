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


public int ladderLength(String start, String end, Set<String> dict) {
	int ans = 1, curcnt = 0, nextcnt = 0;
	Queue<String> que = new LinkedList<String>();
	que.add(start);
	curcnt = 1;
	HashSet<String> hset = new HashSet<String>();
	hset.add(start);
	while (!que.isEmpty()) {
		String top = que.remove();
		curcnt--;
		for (int i = 0; i < top.length(); i++)
			for (int ch = 'a'; ch <= 'z'; ch++) {
				StringBuilder temp = new StringBuilder(top);
				temp.setCharAt(i, (char) ch);
				if (temp.toString().equals(end))
					return ans + 1;
				if (dict.contains(temp.toString()) && !hset.contains(temp.toString())) {
					que.add(temp.toString());
					nextcnt++;
					hset.add(temp.toString());
				}
			}
		if (curcnt == 0) {
			curcnt = nextcnt;
			nextcnt = 0;
			ans++;
		}
	}
	return 0;
}
