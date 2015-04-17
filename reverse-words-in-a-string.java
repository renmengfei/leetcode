// Method 1: o(n) space, concise code
public String reverseWords(String s) {
	String result = "";
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == ' ') continue;
        int pos = i;
        while (i < s.length() && s.charAt(i) != ' ') i++;
        if (result.length() > 0) result = ' ' + result; // case "a", no space in the end
        result = s.substring(pos, i) + result;
    }
    return result;
}


