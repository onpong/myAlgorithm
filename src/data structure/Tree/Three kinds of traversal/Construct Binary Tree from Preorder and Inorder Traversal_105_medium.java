/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Map<Integer,Integer> hash = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i < inorder.length;i++){
            hash.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length,inorder,0,inorder.length);
    }
    public TreeNode helper(int[] preorder,int pStart,int pEnd,int[] inorder,int iStart,int iEnd){
        if(pStart == pEnd)
            return null;
        int rootVal = preorder[pStart];
        TreeNode root = new TreeNode(rootVal);
        int index = hash.get(rootVal);
        int num = index - iStart;
        root.left = helper(preorder,pStart + 1,pStart + num + 1,inorder,iStart,index);
        root.right = helper(preorder,pStart + num + 1,pEnd,inorder,index + 1,iEnd);
        return root;
    }

}