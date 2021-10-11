/**
 * 边走边调整指向，只需要最后把even指向链表第二个元素即可
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode res = head.next;
        ListNode even = head;
        ListNode odd = head.next;
       //若是偶数，那么当odd.next为null时把even指向res即可
       //如是奇数，那么当odd为null时把even指向res即可
       while(odd != null && odd.next != null){
           even.next = odd.next;
           even = even.next;
           odd.next = even.next;
           odd = odd.next;
       }
       even.next = res;
       return head;
        
       
    }
}