//http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
// (1)2的倍数，除了2都不是prime，所以跳过i+=2
// (2)根号n是limit
//(3) prime的整倍数都不是prime，所以 j=i*i, j+=i；加倍数
public class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;
        
        boolean[] notprime = new boolean[n]; // initial all are prime
        
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
// 1不是素数，2是素数
private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
}
