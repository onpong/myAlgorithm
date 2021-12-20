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
 * 双栈
 * O(N)
 * O(N)
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        int count = 1;
        if(root == null)
            return res;
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = 0;
            int isZero = count % 2;
            if(isZero != 0){
                size = stack1.size();
            }else{
                size = stack2.size();
            }
            while(size-- != 0){
                if(isZero != 0){
                    TreeNode node = stack1.pop();
                    temp.add(node.val);
                    if(node.left != null)
                        stack2.push(node.left);
                    if(node.right != null)
                        stack2.push(node.right);
                }else{
                    TreeNode node = stack2.pop();
                    temp.add(node.val);
                    if(node.right != null)
                        stack1.push(node.right);
                    if(node.left != null)
                        stack1.push(node.left);
                }
            }
            res.add(temp);
            count++;
        }
        return res;
    }
}
/**
 * 双端队列
 * O(N)
 * O(N)
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(res.size() % 2 == 0) tmp.addLast(node.val); // 偶数层 -> 队列头部
                else tmp.addFirst(node.val); // 奇数层 -> 队列尾部
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
