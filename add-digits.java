// result只能是1-9, 考虑两位数sum永远是1-9在循环
public class Solution {
    public int addDigits(int num) {
        return 1+ (num-1)%9;
    }
}
