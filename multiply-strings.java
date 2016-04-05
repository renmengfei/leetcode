// Method 1: 不需要reverse string
public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
    
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
    
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  
    
        StringBuilder sb = new StringBuilder();
       
        int i=0;
        while(i<pos.length && pos[i]==0) i++;
        if(i==pos.length) return "0";
        
        while(i<pos.length) sb.append(pos[i++]);
        return sb.toString();
    }
}


// method 2: reverse
public static String multiply(String num1, String num2) {

	num1 = new StringBuffer(num1).reverse().toString();
	num2 = new StringBuffer(num2).reverse().toString();

	int l1 = num1.length();
	int l2 = num2.length();

	int[] result = new int[l1 + l2];
	//bug1: 前一位需要先加，再做余
	for (int i = 0; i < l1; i++) {
		for (int j = 0; j < l2; j++) {
			result[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
			result[i + j + 1] += result[i + j] / 10;
			result[i + j] = result[i + j] % 10;
		}
	}

	int i = l1 + l2 - 1;
	// bug: i>0, 防止0*num， 第一位保证0
	while (i > 0 && 0 == result[i])
			i--;

	StringBuffer sb = new StringBuffer();
	// bug: i=0
	while (i >= 0)
		sb.append(result[i--]);
	return sb.toString();
}
