/**
 * 递归
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null)
            return root1 == null ? root2 : root1;
        return help(root1,root2);
    }
    public TreeNode help(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null){
           return root1 == null ? root2 : root1;
        }
        root1.val = root1.val + root2.val;
        root1.left = help(root1.left,root2.left);
        root1.right = help(root1.right,root2.right);
        return root1;
      
    }
}
/**
 * 迭代
 * O(N)
 * O(N)
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    //如果 t1和t2中，只要有一个是null，函数就直接返回
        if(t1==null || t2==null) {
            return t1==null? t2 : t1;
        }
        java.util.LinkedList<TreeNode> queue = new java.util.LinkedList<TreeNode>();
        queue.add(t1);
        queue.add(t2);
        while(queue.size()>0) {
            TreeNode r1 = queue.remove();
            TreeNode r2 = queue.remove();
            r1.val += r2.val;
            //如果r1和r2的左子树都不为空，就放到队列中
            //如果r1的左子树为空，就把r2的左子树挂到r1的左子树上
            if(r1.left!=null && r2.left!=null){
                queue.add(r1.left);
                queue.add(r2.left);
            }
            else if(r1.left==null) {
                r1.left = r2.left;
            }
            //对于右子树也是一样的
            if(r1.right!=null && r2.right!=null) {
                queue.add(r1.right);
                queue.add(r2.right);
            }
            else if(r1.right==null) {
                r1.right = r2.right;
            }
        }
        return t1;
    }
}
