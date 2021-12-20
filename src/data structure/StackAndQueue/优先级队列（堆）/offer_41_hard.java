class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(
            new Comparator<Integer>(){
                public int compare(Integer o1,Integer o2){
                    return o2 - o1;
                }
            }
        );
    }
    
    public void addNum(int num) {
        //堆的插入和删除调整要logN,
        /**如果两边元素一样，我们就把元素放在minHeap里，
        如果元素不一样，那肯定是A比较多，那么应该往maxHeap添加个元素
         */
         if(minHeap.size() == maxHeap.size()){
             maxHeap.add(num);
             minHeap.add(maxHeap.poll());
         }else{
             minHeap.add(num);
             maxHeap.add(minHeap.poll());
         }
    }
    
    public double findMedian() {
        return minHeap.size() == maxHeap.size() ? (maxHeap.peek() + minHeap.peek()) / 2.0 
        : minHeap.peek() / 1.0;

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */