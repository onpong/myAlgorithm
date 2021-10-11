/**
 * 反转后半部分
 * O(N)
 * O(1)
 */
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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null;
        ListNode temp = null;
        while(slow != null){
            temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        ListNode p = head;
        while(p != pre && pre != null){
            if(p.val != pre.val)
                return false;
            p = p.next;
            pre = pre.next;
        }
        return true;
    }
}
/**
 * 反转前半部分
 * O(N)
 * O(1)
 * 其实本质一样，反转链表时也是先记录下一个位置，然后反转，最后移动
 */

   class Solution{
 public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
            pre = slow;
        }
        if(fast != null) {
            slow = slow.next;
        }
        while(prepre != null && slow != null) {
            if(prepre.val != slow.val) {
                return false;
            }
            prepre = prepre.next;
            slow = slow.next;
        }
        return true;
    }
 }
