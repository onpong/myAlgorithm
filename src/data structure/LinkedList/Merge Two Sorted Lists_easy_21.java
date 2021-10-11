//方法1
//O(N+M)
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode res = null;
        ListNode p = l1;
        ListNode q = l2;
        if(l1.val <= l2.val){
            res = l1;
            p = p.next;
        }else{
            res = l2;
            q = q.next;
        }
        ListNode temp = res;
        while(p != null && q != null){
            if(p.val <= q.val){
                temp.next = p;
                temp = temp.next;
                p = p.next;
            }else{
                temp.next = q;
                temp = temp.next;
                q = q.next;
            }
        }
        if(q == null){
            temp.next = p;
        }else{
            temp.next = q;
        }
        return res;
    }
}
//方法2递归
//O(N+M)
//O(N+M)
//class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
