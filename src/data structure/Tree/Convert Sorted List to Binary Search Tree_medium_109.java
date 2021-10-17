/**
 * 转换成数组
 * O(N)
 * O(N)
 */
//方法1
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
      if(head == null)return null;
      if(head.next == null)return new TreeNode(head.val);

      List<Integer> list = new ArrayList<>();
      while(head != null){
        list.add(head.val);
        head = head.next;
      }
      return buildTree(0, list.size() - 1, list);
    }

    TreeNode buildTree(int left, int right, List<Integer> list){
      if(left > right)return null;
      int mid = left + (right - left + 1) / 2;
      TreeNode root = new TreeNode(list.get(mid));
      root.left = buildTree(left, mid - 1, list);
      root.right = buildTree(mid + 1, right, list);
      return root;
    }
}
/**
 * 链表快慢指针
 * O(NLOGN)
 * O(LOGN)
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast != null  && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if(pre != null){
            pre.next = null;
            root.left = sortedListToBST(head);
        }else{
            root.left = null;
        }
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
/**
 * 中序遍历思路
 * O(N)
 * O(1)
 */
class Solution {
    ListNode ptr;
    public TreeNode sortedListToBST(ListNode head) {
      if(head == null)return null;
      if(head.next == null)return new TreeNode(head.val);

      ptr = head;
      return buildTree(0, length(head) - 1);
    }

    TreeNode buildTree(int left, int right){
      if(left > right)return null;
      int mid = left + (right - left + 1) / 2;
      TreeNode root = new TreeNode();
      TreeNode leftTree = buildTree(left, mid - 1);
      root.val = ptr.val;
      ptr = ptr.next;
      root.left = leftTree;
      root.right = buildTree(mid + 1, right);
      return root;
    }

    int length(ListNode node){
      int len = 0;
      while(node != null){
        len++;
        node = node.next;
      }
      return len;
    }
}