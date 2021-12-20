/**
 * 自己做法
 * O(N)
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return getDepth(root,0);
    }
    public int getDepth(TreeNode node,int height){
        if(node == null){
            return height;
        }
        int left = getDepth(node.left,height + 1);
        int right = getDepth(node.right,height + 1);
        return Math.max(left,right);
    }
}
/**
 * 题解
 */


class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
