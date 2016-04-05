// Method 1: 用iterator
public class Vector2D {
    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;
    
    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    public int next() {
        return j.next();
    }

    public boolean hasNext() {
        //jump empty
        while ((j == null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j != null && j.hasNext();
    }
}

// Method 2: 用两个变量
public class Vector2D implements Iterator<Integer> {
    int indexList, indexEle;
    List<List<Integer>> vec; 
    
    public Vector2D(List<List<Integer>> vec2d) {
        int indexList=0;
        int indexEle=0;
        vec = vec2d;
    }

    @Override
    public Integer next() {
         return vec.get(indexList).get(indexEle++);
    }

    @Override
    public boolean hasNext() {
        while(indexList < vec.size()){
            if(indexEle < vec.get(indexList).size())
                return true;
            else{
                indexList++;
                indexEle = 0;
            }
        }
        return false;
    }
}
