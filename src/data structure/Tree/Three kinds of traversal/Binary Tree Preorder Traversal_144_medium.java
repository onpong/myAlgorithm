/**
 * [preOrderRecur description]
 * @param head [description]
 * 递归
 * O(N)
 * O(N)
 */
public static void preOrderRecur(TreeNode head) {
    if (head == null) {
        return;
    }
    System.out.print(head.value + " ");
    preOrderRecur(head.left);
    preOrderRecur(head.right);
}
/**
 * 迭代
 * O(N)
 * O(N)
 */
public static void preOrderIteration(TreeNode head) {
	if (head == null) {
		return;
	}
	Stack<TreeNode> stack = new Stack<>();
	stack.push(head);
	while (!stack.isEmpty()) {
		TreeNode node = stack.pop();
		System.out.print(node.value + " ");
		if (node.right != null) {
			stack.push(node.right);
		}
		if (node.left != null) {
			stack.push(node.left);
		}
	}
}
/**
 * MORRIS遍历
 * O(N)
 * O(1)
 */
public static void preOrderMorris(TreeNode head) {
	if (head == null) {
		return;
	}
	TreeNode cur1 = head;//cur1为当前遍历到的节点
	TreeNode cur2 = null;//cur2为cur1左子树的最右节点
	while (cur1 != null) {
		cur2 = cur1.left;
		if (cur2 != null) {
			while (cur2.right != null && cur2.right != cur1) {//找到最右节点
				cur2 = cur2.right;
			}
			if (cur2.right == null) {//如果是第一次到最右节点，则把它指向cur1，以便后续回到原位置（这就是空间复杂度降低的关键）
				cur2.right = cur1;
				System.out.print(cur1.value + " ");
				cur1 = cur1.left;
				continue;
			} else {//如果是第二次到，则把它置为空，否则返回的树存在环了
				cur2.right = null;
			}
		} else {//如果没有左子树，则直接打印根节点
			System.out.print(cur1.value + " ");
		}
		cur1 = cur1.right;//要么就是一个节点左子树遍历完了，要么就是没有左子树，cur1才往右走。
	}
}

