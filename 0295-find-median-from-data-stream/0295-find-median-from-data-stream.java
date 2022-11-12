class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((p,q)->q-p);
        minHeap = new PriorityQueue<>((p,q)->p-q);
    }
    
    public void addNum(int num) {
        
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        
        
        if(maxHeap.size() > minHeap.size()){
            // maxHeap.add(minHeap.poll());
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        int maxSize = maxHeap.size() > 0 ? maxHeap.size() : 0;
        int minSize = minHeap.size() > 0 ? minHeap.size() : 0;
        
        int sum = 0;
        if(maxSize == minSize){
            sum = maxHeap.peek() + minHeap.peek();
            return sum/2.0;
        } else {
            sum = minHeap.peek();
            return sum * 1.0;
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */