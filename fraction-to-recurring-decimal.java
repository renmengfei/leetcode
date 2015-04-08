public class Solution {
    //   7/11 -> 0.(63)
    public String fractionToDecimal(int numerator, int denominator) {
        // check 0
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        // check sign
        sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        // bug: when remove sign, overflow problem
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part
        sb.append(num / den);
        num %= den;
        if (num == 0) {
            return sb.toString();
        }
        
        // step 4: fractional part
        sb.append('.');
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, sb.length());
        
        while (num != 0) {
            num*=10;
            sb.append(num/den);
            num%=den;
            if(map.containsKey(num)){
                int index = map.get(num);
                sb.insert(index, '(');
                sb.append(')');
                break;
            }else{
                map.put(num, sb.length());
            }
        }
        return sb.toString();
    }
}
