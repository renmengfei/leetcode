    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        
        if(intervals.size()==0){
            result.add(newInterval);
            return result;
        }
        
        int i=0;
        int n = intervals.size();
        // step 1: skip smaller intervals
        while(i<n && intervals.get(i).end < newInterval.start){
            result.add(intervals.get(i++));
        }
        
        while(i<n && intervals.get(i).start <= newInterval.end){
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i++).end);
        }
        
        result.add(newInterval);
        
        while(i<n){
            result.add(intervals.get(i++));
        }
        return result;
    }
