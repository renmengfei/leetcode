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
