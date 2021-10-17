/**
 * 反转链表
 * O(N)
 * O(1)
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        int count = 0;
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            count++;
        }
        int[] res = new int[count];
        int index = 0;
        while(pre != null){
            res[index++] = pre.val;
            pre = pre.next;
        }
        return res;
    }
}

/**
 * 辅助栈
 * O(N)
 * O(N)
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
    return res;
    }
}
