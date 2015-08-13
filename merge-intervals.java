public List<Interval> merge(List<Interval> intervals) {
	List<Interval> res = new LinkedList<Interval>();
	if (intervals.size() < 2)
		return intervals;

	Collections.sort(intervals, new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			return Integer.compare(o1.start, o2.start);
		}
	});

	Interval curr = intervals.get(0);
	for (Interval iter : intervals) {
		if (curr.end >= iter.start) {
			curr.end = Math.max(curr.end, iter.end);
		} else {
			res.add(cur);
			curr = iter;
		}
	}
	// bug:记住最后一个
	res.add(curr);
	return res;
}
