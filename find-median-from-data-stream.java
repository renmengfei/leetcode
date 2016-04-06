// minHeap存大的一半，maxHeap存小的一半，
// minheap:  6,7,8
// maxHeap: 3, 2, 1
//这样peek出来的才是median
//难点在于维护两个heap的size
class MedianFinder {
    PriorityQueue<Integer> max = new PriorityQueue<Integer>(100, Collections.reverseOrder());
    PriorityQueue<Integer> min = new PriorityQueue<Integer>();
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (max.size() < min.size()){
            max.offer(min.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
         if (max.size() == min.size()) return (max.peek() + min.peek()) /  2.0;
         else return max.peek();
    }
};
