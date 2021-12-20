/**
 * O(N)
 * O(N)
 */
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0)
            return new int[]{};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            new Comparator<Integer>(){
                public int compare(Integer o1,Integer o2){
                    return o2 - o1;
                }
            }
        );
        for(int i = 0;i < arr.length;i++){
           if(maxHeap.size() < k){
               maxHeap.offer(arr[i]);
           }else if(maxHeap.peek() > arr[i]){
               maxHeap.poll();
               maxHeap.offer(arr[i]);
           }
        }
        int[] res = new int[k];
        int i = 0;
        for(Integer o : maxHeap){
            res[i++] = o;
        }
        return res;
    }
    
}