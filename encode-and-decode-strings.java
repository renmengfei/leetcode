public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for(String s: strs){
            sb.append(s.length()+"#"+s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<String>();
        
        int i=0;
        while(i<s.length()){
            int slash = s.indexOf("#", i);
            int len = Integer.parseInt(s.substring(i, slash));
            String word = s.substring(slash+1, slash+len+1);
            result.add(word);
            i=slash+len+1;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
