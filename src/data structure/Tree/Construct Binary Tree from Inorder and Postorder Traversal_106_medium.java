/**
 * O(N)
 * O(N)
 */
class Solution {
    private Map<Integer,Integer> hash = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i < inorder.length;i++){
            hash.put(inorder[i],i);
        }
        return helper(postorder,0,postorder.length,inorder,0,inorder.length);
    }
    public TreeNode helper(int[] postorder,int pStart,int pEnd,int[] inorder,int iStart,int iEnd){
        if(pStart == pEnd || iStart == iEnd)
            return null;
        int rootVal = postorder[pEnd - 1];
        TreeNode root = new TreeNode(rootVal);
        int index = hash.get(rootVal);
        int num = index - iStart;
        root.left = helper(postorder,pStart,pStart + num,inorder,iStart,index);
        root.right = helper(postorder,pStart + num,pEnd - 1,inorder,index + 1,iEnd);
        return root;
    }
}