http://buttercola.blogspot.com/2015/08/leetcode-meeting-rooms-ii.html
// Method 1: merge sort
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        
        for(int i=0;i<n;i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int count = 1, result = 1;
        int i=1, j=0;
        
        while(i<n && j<n){
            if(start[i]<end[j]){
                count++;
                result = Math.max(result, count);
                i++;
            }
            else{
                count--;
                j++;
            }
        }
        return result;
    }

// Method 2: priority queue
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // sort start
        Arrays.sort(intervals, new Comparator<Interval>(){
           
           @Override
           public int compare(Interval o1, Interval o2){
               return Integer.compare(o1.start, o2.start);
           }
       });
       
       
        PriorityQueue<Interval> q = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) { 
                return Integer.compare(o1.end, o2.end);
            }
        });
    
       q.offer(intervals[0]);
       
       for(int i=1;i<intervals.length; i++){
            Interval pointer = q.poll();
            
            if(intervals[i].start>=pointer.end){
                pointer.end = intervals[i].end;
            }
            else{
                q.offer(intervals[i]);
            }
            q.offer(pointer);
       }
       return q.size();
    }

