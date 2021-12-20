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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode cur = res;
        int c = 0;
        ListNode p = l1;
        ListNode q = l2;
        while(p != null && q != null){//两个链表都有的部分
            if(p.val + q.val + c > 9){
                cur.next = new ListNode(p.val + q.val  + c - 10);
                c = 1;
            }else{
                cur.next = new ListNode(p.val + q.val + c);
                c = 0;
            }
            cur = cur.next;
            p = p.next;
            q = q.next;
        }
        ListNode temp = p == null ? q : p;
        while(temp != null){//较长链表的剩余部分
            if(temp.val + c > 9){
                cur.next = new ListNode(temp.val + c - 10);
                c = 1;
            }else{
                cur.next = new ListNode(temp.val + c);
                c = 0;
            }
            cur = cur.next;
            temp = temp.next;
        }
        if(c == 1)//如果最后有进位再生成一个
            cur.next = new ListNode(1);
        return res.next;

    }
}

/**
 * 简化版
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;
            
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
