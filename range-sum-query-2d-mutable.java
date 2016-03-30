// Method 2: quad-tree, 跟segment tree一样，但是超时，代码太长
public class NumMatrix {
    class Pair {
        int x, y;
        public Pair(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }

    class SegmentTree {
        Pair start, end;
        int sum;
        SegmentTree[] children;

        public SegmentTree(int row1, int col1, int row2, int col2) {
            this.start = new Pair(row1, col1);
            this.end = new Pair(row2, col2);
            this.sum = 0;
            this.children = new SegmentTree[4];
        }
    }
    
    SegmentTree root;
    int[][] nums;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return;

        nums = matrix;
        root = buildTree(0,0,matrix.length-1, matrix[0].length-1);
    }
    
    public SegmentTree buildTree(int row1, int col1, int row2, int col2){
        if(row1>row2 || col1>col2) return null;
        SegmentTree root = new SegmentTree(row1, col1, row2, col2);
        if(row1==row2 && col1==col2){
            root.sum = nums[row1][col1];
            return root;
        }
        else{
            int midx = (row1+row2)/2;
            int midy = (col1+col2)/2;
            
            root.children[0]=buildTree(row1, col1, midx, midy);
            root.children[1]=buildTree(row1, midy+1, midx, col2);
            root.children[2]=buildTree(midx+1, col1, row2, midy);
            root.children[3]=buildTree(midx+1, midy+1, row2, col2);
            
            for(int i=0;i<4;i++){
                 if(root.children[i]!=null) root.sum+=root.children[i].sum;
            }
        }
        return root;
    }

    public void update(int row, int col, int val) {
        int diff = val-nums[row][col];
        if(diff==0) return;
        nums[row][col]=val;
        update(row, col, diff, root);
    }
    
    public void update(int row, int col, int diff, SegmentTree node){
        if(row>=node.start.x && row<=node.end.x && col>=node.start.y && col<=node.end.y){
            node.sum+=diff;
            
            for(int i=0;i<4;i++){
                if(node.children[i]!=null) update(row, col, diff, node.children[i]);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion(row1, col1, row2, col2, root);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2, SegmentTree node){
        Pair start = node.start;
        Pair end = node.end;
        
        int top = Math.max(row1, start.x);
        int bottom = Math.min(row2, end.x);
        if(top>bottom) return 0;
        
        int left = Math.max(col1, start.y);
        int right = Math.min(col2,end.y);
        if(left>right) return 0;
        
        if(row1<=start.x && col1<=start.y && row2>=end.x && col2 >=end.y){
            return node.sum;
        }
        
        int sum=0;
        
        for(int i=0;i<4;i++){
            if(root.children[i]!=null)
                sum+=sumRegion(row1, col1, row2, col2, root.children[i]);
        }
        return sum;
    }
}
