class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((p,q)->q-p);
        minHeap = new PriorityQueue<>((p,q)->p-q);
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() && minHeap.isEmpty()){
            maxHeap.add(num);
        } else if(minHeap.isEmpty()) {
            if(num >= maxHeap.peek()) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
                minHeap.add(maxHeap.poll());
            }
        } else {
            //both are non empty
            if(num > minHeap.peek()) {
                
                if(minHeap.size() < maxHeap.size()) {
                    minHeap.add(num);
                } else {
                    minHeap.add(num);
                    maxHeap.add(minHeap.poll());
                    
                }
                
            } else {
                if(minHeap.size() < maxHeap.size()) {
                    maxHeap.add(num);
                    minHeap.add(maxHeap.poll());
                    
                } else {
                    maxHeap.add(num);
                }
            }
        }
    }
    
    public double findMedian() {
        int maxSize = maxHeap.size() > 0 ? maxHeap.size() : 0;
        int minSize = minHeap.size() > 0 ? minHeap.size() : 0;
        
        int sum = 0;
        if(maxSize == minSize){
           sum = (maxHeap.size() > 0 ? maxHeap.peek() : 0) + (minHeap.size() > 0 ? minHeap.peek() : 0); 
            return sum/2.0;
        } else {
            sum = maxHeap.peek();
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