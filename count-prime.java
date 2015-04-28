//http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
public class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        
        boolean[] notprime = new boolean[n+1]; // initial all are prime
        
        // 跳过2的倍数
        for(int i=3;i<Math.sqrt(n);i+=2){
            if(!notprime[i]){
                for(int j= i*i; j<n;j+=i){
                    notprime[j]=true;
                }
            }
        }
        
        //count
        int sum = 1; // 2 is prime
        for (int i = 3; i < n; i += 2){
            sum += (notprime[i]==false) ? 1 : 0;
        }
        return sum;
    }
}


// 判断一个数是否是prime
// time: log(N)/2 
public boolean isPrime(int n){
    if(n%2==0) return false;
   
    for(int i=3; i<=Math.sqrt(n);i+=2){
        if(n%i==0) return false;
    }
    return true;
}
