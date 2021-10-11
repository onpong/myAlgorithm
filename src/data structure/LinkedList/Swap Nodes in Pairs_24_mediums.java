//方法1：迭代法
//O(N)
//O(1)
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
    //pre和cur代表要交换的两个节点，ppre代表pre之前的节点，after代表cur之后的节点。
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode after = head;
        ListNode ppre = res;
        while(after != null && after.next != null){
            ListNode pre = ppre.next;
            ListNode cur = pre.next;
            ppre.next = cur;
            after = cur.next;
            cur.next = pre;
            pre.next = after;
            ppre = pre;
            
        }
        return res.next;
    }
}
//递归
//O(N)
//O(N)
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}

