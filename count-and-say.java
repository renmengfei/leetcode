// bug: cannot directly concat integer and char. So I add "" between them
public class Solution {
	public String countAndSay(int n) {
		String previous = "1";
		for(int i=1;i<n;i++){
			previous = getNext(previous);
		}
		
		return previous;
	}
	
	public String getNext(String s){
		int count = 1;
		char pivot = s.charAt(0);
		String result = "";
		for(int i=1;i<s.length();i++){
			if(s.charAt(i)==pivot) count++;
			else{
				result+=count+""+pivot;
				pivot = s.charAt(i);
				count=1;
			}
		}
		result+=count+""+pivot;
		return result;
	}
}
