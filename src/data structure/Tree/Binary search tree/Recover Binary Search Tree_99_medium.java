/**
 * O(N)
 * O(1)
 */
class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        TreeNode x = null;
        TreeNode y = null;
        TreeNode pre = null;
        while(cur1 != null){
            cur2 = cur1.left;
            if(cur2 != null){
                while(cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if(cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }
                if(cur2.right == cur1){
                    cur2.right = null;
                }
            }
            //如果是第一次找到错误位置那么更新x，y如果第二次找到错误的位置那么只需要更新y
            //第二次错误的位置必定是和x交换的。
           if(pre != null && pre.val > cur1.val){
                x = x == null ? pre : x;
                y = cur1;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}