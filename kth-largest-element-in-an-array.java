// Method 1: O(N*LogN) time, O(1) space
public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
}

// Method 2: Priority Queue, O(N*logK) time, O(k) space
// 永远只存k个，而不是全部放进queue
public int findKthLargest(int[] nums, int k) {

    final PriorityQueue<Integer> pq = new PriorityQueue<>();
    for(int val : nums) {
        pq.offer(val);

        if(pq.size() > k) {
            pq.poll();
        }
    }
    return pq.peek();
}

// Method 3: selection sort/ quick sort. O(N) best, O(N^2)time, O(1) memory
public class Solution {
    public int findKthLargest(int[] nums, int k) {
       quickSort(nums, 0, nums.length-1);
       
       return nums[nums.length-k];
       
    }
    
    
   public void quickSort(int arr[], int left, int right) {
      int index = partition(arr, left, right);
      if (left < index - 1)
            quickSort(arr, left, index - 1);
      if (index < right)
            quickSort(arr, index, right);
   }
    
    int partition(int arr[], int left, int right)
    {
          int i = left, j = right;
          int tmp;
          int pivot = arr[(left + right) / 2];
         
          while (i <= j) {
                while (arr[i] < pivot)
                      i++;
                while (arr[j] > pivot)
                      j--;
                if (i <= j) {
                      tmp = arr[i];
                      arr[i] = arr[j];
                      arr[j] = tmp;
                      i++;
                      j--;
                }
          };
         
          return i;
    }
    
}


// Quick Select
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, 0, nums.length-1, k-1);
    }
    
    public int quickselect(int[] G, int first, int last, int k) {
      if (first <= last) {
            int pivot = partition(G, first, last);
            if (pivot == k) {
                return G[k];
            }
            if (pivot > k) {
                return quickselect(G, first, pivot - 1, k);
            }
            return quickselect(G, pivot + 1, last, k);
      }
        return Integer.MIN_VALUE;
    }


    public int partition(int[] nums, int start, int end){
        // int pivot = start + new Random().nextInt(end - start + 1);
        // swap(nums, pivot, end);
        
        for(int i=start; i<end; i++){
            if(nums[i]>nums[end]){
                swap(nums, i, start);
                start++;
            }
        }
        
        swap(nums, start, end);
        return start;
    }
    
    public void swap(int[] num, int i, int j){
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
