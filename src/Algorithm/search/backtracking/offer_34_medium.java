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
/**
 * O(N)
 * O(N)
 */
class Solution {
    private List<Integer> tempPath = new ArrayList<>();
    private int tempSum = 0;
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        help(root,target);
        return res;
    }
    public void help(TreeNode root, int target){
        /**
        采用先序遍历
        无需返回
        空节点或者当总和大于target时终止
        每层：判断加上当前节点后的总和是否等于target，若等于且是叶子节点，就把当前路劲加入答案。
        否则加入tempSum
         */
        if(root == null)
            return;
        tempPath.add(root.val);
        if(tempSum + root.val == target && root.left == null && root.right == null){
            res.add(new ArrayList<>(tempPath));     
        }
        tempSum += root.val;
        help(root.left,target);
        help(root.right,target);
        tempPath.remove(tempPath.size() - 1);
        tempSum -= root.val;
    }
}