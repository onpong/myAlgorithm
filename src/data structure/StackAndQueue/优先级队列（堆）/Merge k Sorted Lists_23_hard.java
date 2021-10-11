/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {    
       if (lists.length == 0) return null;
        ListNode res = new ListNode(0);
        ListNode p = res;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            new Comparator<ListNode>(){
                public int compare(ListNode o1,ListNode o2){
                    if(o1.val > o2.val){
                        return 1;
                    }else if(o1.val == o2.val){
                        return 0;
                    }else{
                        return -1;
                    }
                }
            }
        );
        for(ListNode node : lists){
            if(node != null)
                minHeap.offer(node);
        }
        while(!minHeap.isEmpty()){
            p.next = minHeap.poll();
            p = p.next;
            if(p.next != null){
                minHeap.offer(p.next);
            }

        }
        return res.next;
    }
}