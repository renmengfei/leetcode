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

// Majority Number II
// 找出现1/3的数，只有一个

int candi1, candi2;
int count1, count2;

if(candi1==nums[i])count1++;
else if(candi2==nums[i]) count2++;
else if(count1==0) candi1 = nums[i];
else if(count2==0) candi2 = nums[i];
else{ count1--; count2--;}

// 怎么找candi1， candi2哪个是呢？再次for循环
// 统计candi1，candi2的次数，用次数大的
// 为什么不能直接用count大的数呢？ 1, 0, 1, 0, 1, 0, 1, 2, 2, 2
// 1的count被抵消了


// Majority Number III
// 找1/k的数
// 用hash, 保存k-1个数
