/**
 * 递归
 * O(N)
 * O(N)
 */
public static void preOrderRecur(TreeNode head) {
    if (head == null) {
        return;
    }
    preOrderRecur(head.left);
    System.out.print(head.value + " ");
    preOrderRecur(head.right);
}

/**
 * 迭代
 * O(N)
 * O(N)
 */
public static void inOrderIteration(TreeNode head) {
	if (head == null) {
		return;
	}
	TreeNode cur = head;
	Stack<TreeNode> stack = new Stack<>();
	while (!stack.isEmpty() || cur != null) {
		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}
		TreeNode node = stack.pop();
		System.out.print(node.value + " ");
		if (node.right != null) {
			cur = node.right;
		}
	}
}


/**
 * Morris
 * O(N)
 * O(1)
 */
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while(cur1 != null){
            cur2 = cur1.left;
            if(cur2 != null){
                while(cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if(cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else{
                    cur2.right = null;
                }
            }
            res.add(cur1.val);//和前序遍历相比，其实只有这个步骤位置不同。
            cur1 = cur1.right;
        }
        return res;
    }
    }