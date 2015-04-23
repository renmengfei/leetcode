// 找m，n leftmost common digits
public int rangeBitwiseAnd(int m, int n) {
        int mask=Integer.MAX_VALUE;
        while((n&mask) != (m&mask)) mask<<=1;
        return m&mask;
}
