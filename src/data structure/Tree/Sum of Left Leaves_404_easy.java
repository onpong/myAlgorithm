/**
 * 迭代，前序遍历
 * O(N)
 * O(N)
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        int res = 0;
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp.left != null && temp.left.left == null && temp.left.right == null)
                res += temp.left.val;
            if(temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
        }
        return res;
    }
}

/**
 * 递归
 * O(N)
 * O(N)
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int midValue = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) { // 中
            midValue = root.left.val;
        }
        int leftValue = sumOfLeftLeaves(root.left);  // 左
        int rightValue = sumOfLeftLeaves(root.right);    // 右
        int sum = midValue + leftValue + rightValue;
        return sum;

    }
}