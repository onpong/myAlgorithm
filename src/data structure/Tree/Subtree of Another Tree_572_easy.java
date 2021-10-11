/**
 * O(N)
 * O(N)
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null)
            return false;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot) || check(root,subRoot);
    }
    public boolean check(TreeNode root,TreeNode subRoot){
        if(root == null && subRoot == null)
            return true;
        if(root == null || subRoot == null)
            return false;
        if(root.val != subRoot.val)
            return false;
        return check(root.left,subRoot.left) && check(root.right,subRoot.right);
    }
}