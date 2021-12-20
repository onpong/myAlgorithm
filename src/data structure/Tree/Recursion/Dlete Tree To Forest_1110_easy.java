/**
 * O(N)
 * O(N)
 */
class Solution {
    private List<TreeNode> list = new ArrayList<>();
    Set<Integer> hashSet;
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        hashSet = new HashSet<>(to_delete.length);
        for(int i = 0; i < to_delete.length;i++)
            hashSet.add(to_delete[i]);
       dfs(root,true);
       return res;
    }
    public boolean dfs(TreeNode root,boolean isAdd){
        if(root == null)
            return false;
        if(hashSet.contains(root.val)){
            if(dfs(root.left,true)){root.left = null;}
            if(dfs(root.right,true)){root.right = null;}
            return true;
        }
        if(isAdd){
            res.add(root);
        }
        if(dfs(root.left,false)){root.left = null;}
        if(dfs(root.right,false)){root.right = null;}
        return false;

    }
}