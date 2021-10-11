/**
 * 递归解法
 * O(NLOGN)
 * O(N)
 */

class Solution {
    public ListNode sortList(ListNode head) {
       //每次返回归并排序后的第一个元素
       if(head == null || head.next == null)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode res = new ListNode(0,head);
        ListNode h = res;
        while(left != null && right != null){
            if(left.val < right.val){
                h.next = left;
                h = h.next;
                left = left.next;
            }else{
                h.next = right;
                h = h.next;
                right = right.next;
            }
        }
        h.next = left == null ? right : left;
        return res.next;   
    }
    
}
/**
 * 非递归
 * O(NLOGN)
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
    public ListNode sortList(ListNode head) {
       //每次返回归并排序后的第一个元素
       //统计链表长度
       ListNode res = new ListNode(0,head);
       ListNode p = head;
       int len = 0;
       while(p != null){
           len++;
           p = p.next;
       }
       for(int round = 1; round <= len;round *= 2){
           ListNode pre = res;
           ListNode cur = pre.next;
           while(cur != null){
               ListNode left = cur;
               ListNode right = split(left,round - 1);
               cur = split(right,round - 1);
               pre.next = merge(left,right);
               while(pre.next != null){
                   pre = pre.next;
               }
           }
       }
    return res.next;
    }
    public ListNode split(ListNode head,int step){
        while(step-- != 0 && head != null){
            head = head.next;
        }
        if(head == null)
            return null;
        ListNode right = head.next;
        head.next = null;
        return right;
    }
    public ListNode merge(ListNode left,ListNode right){
        ListNode res = new ListNode(0);
        ListNode p = res;
        while(left != null && right != null){
            if(left.val < right.val){
                p.next = left;
                p = p.next;
                left = left.next;
            }else{
                p.next = right;
                p = p.next;
                right = right.next;
            }
        }
        p.next = left == null ? right : left;
        return res.next;
    }
    
}