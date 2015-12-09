// http://www.cnblogs.com/zuoyuan/p/3719753.html
/*
*Given an array of integers, every element appears three times except for one. Find that single one. 
*/
    public int singleNumber(int[] A) {
        //Method 1: O(n) time, some memory
        int[] cache = new int[32];
        int result = 0;
        
        for(int i=0;i<32;i++){
            for(int j=0;j<A.length;j++){
                int tmp = (A[j]>>i)&1;
		if(tmp>0)
                	cache[i]=(cache[i]+1)%3;
            }
            result|=cache[i]<<i;
        }
        return result;
        
        
        //Method 2, O(n)
        int ones=0, twos=0, three=0;
        for(int i=0;i<A.length;i++){
            twos |= ones & A[i]; // & same number remains same, | is plus
            ones ^= A[i]; // ^ can find out odd count
            three = ones & twos;   // three don't need |=
            ones &= ~three;
            twos &= ~three;
            
        }
        return ones;
    }


// Single Number III
//其他可以出现2次，有2个数只出现一次，求这两个数
//(1) a1^a2....^an = ai ^ aj
//(2)根据ai ^ aj结果的某一位为1的，将a[]分为两堆
//(3)两堆各自xor
