public class Solution {
public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> result = new ArrayList<String>();
		if (strs == null || strs.length == 0)
			return result;

		HashMap<String, ArrayList<String>> table = new HashMap<String, ArrayList<String>>();
		for (String s : strs) {
			char[] cstr = s.toCharArray();
			Arrays.sort(cstr);
			String key = new String(cstr);
			if (table.containsKey(key)) {
				table.get(key).add(s);
			} else {
				ArrayList<String> newlist = new ArrayList<String>();
				newlist.add(s);
				table.put(key, newlist);
			}
		}

		for (String key : table.keySet()) {
			ArrayList<String> tmp = table.get(key);
			// bug: size must > 1, or there's only one word
			if (tmp.size() > 1) {
				result.addAll(tmp);
			}
		}
		return result;
	}
}


// sort function, count sort
public static String sort(String s){
    StringBuffer sb = new StringBuffer();
    int[] character = new int[26];
    for(int i = 0; i<s.length(); i++){
        int count = s.charAt(i)-'a';
        character[count]++;
    }

    for(int i = 0; i<26; i++){
        while(character[i]>0){
            sb.append((char)('a'+i));
            character[i]--;
        }
    }

    return sb.toString();
}
