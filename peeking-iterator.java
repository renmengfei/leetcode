// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Integer peeked = null;
    private Iterator<Integer> iter;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    if(iterator==null) return;
	    this.iter = iterator;
	    if(iter.hasNext()){
	        peeked = iter.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peeked;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer result = peeked;
	    
	    peeked = iter.hasNext()? iter.next(): null;
	    return result;
	}

	@Override
	public boolean hasNext() {
	    return peeked!=null || iter.hasNext();
	}
}
