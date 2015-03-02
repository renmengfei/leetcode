//Method 1: O(N) O(1)
//Moore’s Voting Algorithm
//each time, pick any two elements, if they're different, then, remove both of them. As the majority element appears more than n/2 times, when the whole array is scanned once, it's guaranteed that the remaining elements are the majority ones.
public class Solution {
    public int majorityElement(int[] num) {
        int majority=num[0];
        int count=1;
        for(int i=1;i<num.length;i++){
            if(count==0){
                majority=num[i];
            }
            if(num[i]==majority)count++;
            else count--;
        }
        
        return majority;
    }
}


