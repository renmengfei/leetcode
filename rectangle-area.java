    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = oneRec(A,B,C,D);
        int areaB = oneRec(E,F,G,H);
        
        int left = Math.max(A,E);
        int right = Math.min(C,G);
        int top = Math.min(D,H);
        int bottom = Math.max(B,F);
        
        int overlap = 0;
        if(right>left && top>bottom){
            overlap = oneRec(left, bottom, right, top);
        }
        
        return areaA+areaB-overlap;
    }
    
    public int oneRec(int A, int B, int C, int D){
        int height = D-B;
        int width = C-A;
        return height*width;
    }
