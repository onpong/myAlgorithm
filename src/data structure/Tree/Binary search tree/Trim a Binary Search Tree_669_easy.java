/**
 * 递归
 * O(N)
 * O(N)
 * @param  root [description]
 * @param  low  [description]
 * @param  high [description]
 * @return      [description]
 */
public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            //因为是二叉搜索树,节点.left < 节点 < 节点.right
            //节点数字比low小,就把左节点全部裁掉.
            root = root.right;
            //裁掉之后,继续看右节点的剪裁情况.剪裁后重新赋值给root.
            root = trimBST(root, low, high);
        } else if (root.val > high) {
            //如果数字比high大,就把右节点全部裁掉.
            root = root.left;
            //裁掉之后,继续看左节点的剪裁情况
            root = trimBST(root, low, high);
        } else {
            //如果数字在区间内,就去裁剪左右子节点.
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        return root;
    }
/**
 * 前序遍历
 * O(N)
 * O(N)
 */
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode head = new TreeNode(-1);
        head.right = root;
        head.left = null;
        preorder(head,low,high);
        return head.right;
    }
    public void preorder(TreeNode root,int low, int high){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            while(temp.left != null && (temp.left.val < low || temp.left.val > high)){//循环的去处理左子树，直到左子树>low < high或者左子树为空
                if(temp.left.val < low)
                    temp.left = temp.left.right;
                else if(temp.left.val > high)
                    temp.left = temp.left.left;
            }
            while(temp.right != null && (temp.right.val < low || temp.right.val > high)){
                if(temp.right.val < low)
                    temp.right = temp.right.right;
                else if(temp.right.val > high)
                    temp.right = temp.right.left;
            }
            if(temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
        }
    }
}