public int firstMissingPositive(int[] A) {
		int n = A.length;
		 for(int i = 0; i < n; ++ i)
		 //不能写A[i]!=i+1, 因为可能有重复，位置已经被占，会死循环[1,1]
	            while(A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i])
	                swap(A, i, A[i] - 1);

	        for(int i = 0; i < n; ++ i)
	            if(A[i] != i + 1)
	                return i + 1;

	        return n + 1;
	}
	
	public void swap(int[] A, int i, int j){
		int tmp = A[i];
		A[i]=A[j];
		A[j]=tmp;
	}
