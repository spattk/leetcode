class MedianFinder {
    
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;
    Double median;

    /** initialize your data structure here. */
    public MedianFinder() {
        maxheap = new PriorityQueue<>((a,b)->b-a);
        minheap = new PriorityQueue<>((a,b)->a-b);
        median = 0.0;
    }
    
    public void addNum(int num) {
        int l = maxheap.size();
        int r = minheap.size();
        
        if (l == 0){
            maxheap.offer(num);
        } else if (l == r){
            if (num < minheap.peek()){
                maxheap.offer(num);
            } else {
                Integer temp = minheap.poll();
                maxheap.offer(temp);
                minheap.offer(num);
            }
        } else {
            
            if (r == 0) {
                if (num > maxheap.peek()){
                    minheap.offer(num);
                } else {
                    Integer temp = maxheap.poll();
                    minheap.offer(temp);
                    maxheap.offer(num);
                }
            }
            
            else if (num > maxheap.peek()){
                minheap.offer(num);
                
            } else {
                Integer temp = maxheap.poll();
                minheap.offer(temp);
                maxheap.offer(num);
            }
            
        }
    
    }
    
    public double findMedian() {
        if (maxheap.size() == minheap.size()){
            return (maxheap.peek() + minheap.peek()) / 2.0;
        } else {
            return (double) maxheap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */