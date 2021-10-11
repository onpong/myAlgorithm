/**
 * 方法1
 * O(N)
 * O(1)
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = length(headA);
        int len2 = length(headB);
        ListNode p = headA;
        ListNode q = headB;
        if(len1 > len2){
            int temp = len1 - len2;
            while(temp-- != 0){
                p = p.next;
            }
        }else{
            int temp = len2 - len1;
            while(temp-- != 0){
                q = q.next;
            }
        }
        while(p != null && q != null){
            if(p == q){
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }
    public int length(ListNode head){
        ListNode p = head;
        int len = 0;
        while(p != null){
            len++;
            p = p.next;
        }
        return len;
    }
}
/**
 * 方法2
 */
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    ListNode pA = headA, pB = headB;
    while (pA != pB) {
        pA = pA == null ? headB : pA.next;
        pB = pB == null ? headA : pB.next;
    }
    return pA;
}
