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
