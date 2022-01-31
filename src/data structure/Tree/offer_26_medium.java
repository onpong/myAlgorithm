/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * O(MN)
 * O(M)
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null)
            return false;
        return help(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    public boolean help(TreeNode A, TreeNode B){
         /**
         此函数用来判断B是否以A为根节点的子结构，这是基本操作，要记住
        递归法：
        返回：B是否是以A为根节点的树的子结构
        终止条件：当B节点为叶子节点时返回true
        每层做什么：B若和A相等，继续往孩子走
         */
        if(B == null)
        return true;
        if(A == null)
            return false;
        if(A.val != B.val)
            return false;
        return help(A.left,B.left) && help(A.right,B.right);

    }
}