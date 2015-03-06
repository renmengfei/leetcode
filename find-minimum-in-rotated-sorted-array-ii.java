public class Solution {
    public int findMin(int[] num) {
		return findMin(num, 0, num.length-1);
	}


	private int findMin(int[] num, int start, int end) {
		if(start==end) return num[start];
		//normal order
		if(num[start]<num[end]) return num[start];
		int mid = (start+end)/2;
		//mess on right
		if(num[mid]>num[start]){
			return findMin(num,mid+1,end);
		}
		// mess on left
		else if(num[mid]<num[start]){
			return findMin(num, start, mid);
		}
		else{
			return findMin(num, start+1,end);
		}
	}
}
