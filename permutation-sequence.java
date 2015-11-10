// Method 1: Using Next Permutation
    // public String getPermutation(int n, int k) {
    //     // Note: The Solution object is instantiated only once and is reused by each test case.
        
    //     int[] first = new int[n];
    //     if(n==1) return "1";
    //     for(int i=0;i<n;i++) first[i]=i+1;
        
    //     for(int i=2;i<=k;i++){
    //         getNextPermutation(first);
    //     }
        
    //     String ret = "";
    //     for(int i: first){
    //         ret+=i;
    //     }
    //     return ret;
    // }
    
    // public void getNextPermutation(int[] num){
    //     int n  = num.length;
        
    //     int i=n-2;
    //     for(;i>=0;i--){
    //         if(num[i]<num[i+1]){
    //             int j = n-1;
    //             for(;j>i;j--){
    //                 if(num[j]>num[i]) break;
                    
    //             }
    //             swap(num,i,j);
    //             reverse(num, i+1, n-1);
    //             return;
    //         }
    //     }
        
    // }
    
    
    // public void swap(int[] num, int i, int j){
    //     int tmp = num[i];
    //     num[i]=num[j];
    //     num[j]=tmp;
    // }
    
    // public void reverse(int[] num, int start, int end){
    //     while(start<end){
    //         swap(num, start, end);
    //         start++;
    //         end--;
    //     }
    // }

// Method 2:
//方法二： find out which digit in which position
    //这n！个排列中，第一位的元素总是(n-1)!一组出现的，也就说如果p = k / (n-1)!，那么排列的最开始一个元素一定是arr[p]
    
    public String getPermutation(int n, int k) {
        ArrayList<Character> table = new ArrayList<Character>();
        int factorial = 1;
        
        for(int i=0;i<n;i++){
            table.add((char)('1'+i));
            factorial *=(i+1);
        }
        
        k = k-1;//index减1，  比如kth=6, index = 5
        factorial/=n;//(n-1)!
        
        String ret="";
        //因为最后一位没有选择（挑剩余的），不能通过这种方法得到数值，必须通过数组swap
        for(int i=0;i<n-1;i++){
            int digit = k/factorial;//注意 table[digit]=digit+1
            k=k%factorial;
            factorial/=(n-i-1);
            
            char temp = table.get(digit);
            table.remove(digit);//删掉用过的
            ret+=temp;
        }
        ret+=table.get(0);
        return ret;
    }

