public class Solution {
 public List<String> restoreIpAddresses(String s) {
	    List<String> solutions = new ArrayList<String>();
	    restoreIp(s, solutions, 0, "", 0);
	    return solutions;
	}

	private void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {
	    if (count > 4) return;
	    if (count == 4 && idx == ip.length()) solutions.add(restored);

	    for (int i=1; i<=3; i++) {
	    	//bug1: not enough digits for the next level
	        if (idx+i > ip.length()) break;
	        String s = ip.substring(idx,idx+i);
	        //bug2: 000 is a wrong IP, cannot simply use Integer.parser(s)
	        if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) continue;
	        restoreIp(ip, solutions, idx+i, restored+s+(count==3?"" : "."), count+1);
	    }
	}
}
