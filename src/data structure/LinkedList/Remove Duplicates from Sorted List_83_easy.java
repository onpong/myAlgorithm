/**
 * 非递归解法
 * O(N)
 * O(1)
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode cur = head;
        while(pre != null && pre.next != null){
            cur = pre.next;
            if(cur.val == pre.val){
                pre.next = cur.next;
            }else{
                pre = pre.next;
            }
            
        }
        return head;
    }
}
/**
 * 递归解法
 * O(N)
 * O(1)
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(!head||!head->next)
            return head;
        head->next=deleteDuplicates(head->next);
        if(head->val==head->next->val) head=head->next;
        return head;
    }
};

