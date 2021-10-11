/**
 * 
 */
class Solution {
    private int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return res;
    }
    public int getDepth(TreeNode node){
        if(node == null)
            return 0;
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        if(left + right > res)
            res = left + right;
        return left > right ? left + 1 : right + 1;
    }

}