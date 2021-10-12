/**
 * 方法1
 * O(N)
 * O(N)
 */
class Solution {
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         //只需要判断一个节点的左右子树（包括自己），是否同时包含有p和q
        helper(root,p,q);
        return res;
    }
    public boolean helper(TreeNode root,TreeNode p,TreeNode q){
        if(root == null)
            return false;
        boolean self = false;
        if(root.val == p.val || root.val == q.val)
            self = true;
        boolean left = helper(root.left,p,q);
        boolean right = helper(root.right,p,q);
        if(res != null)
            return true;
        if(self == true && (left == true || right == true)){
            res = root;
        }
        if(left == true && right == true)
            res = root;
        return self || left || right;
    }
}
/**
 * 方法2
 * O(N)
 * O(N)
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null; // 1.
        if(left == null) return right; // 3.
        if(right == null) return left; // 4.
        return root; // 2. if(left != null and right != null)
    }
}
