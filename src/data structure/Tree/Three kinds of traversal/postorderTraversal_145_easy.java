/**
 * 递归
 * O(N)
 * O(N)
 */
public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }


/**
 * 迭代
 * O(N)
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.push(cur);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            res.addFirst(temp.val);
            if(temp.left != null){
                stack.push(temp.left);
            }
            if(temp.right != null){
                stack.push(temp.right);
            }

        }
        return res;
    }
}
/**
 * .如果不依赖队列，就是左右根的遍历顺序该怎么做？
 * O(N)
 * O(N)
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        if (root == nullptr) return {};
        stack<TreeNode*> stk;
        stk.push(root);
        vector<int> res;
        while (!stk.empty()) {
            TreeNode* node = stk.top();
            if (node == nullptr) {
                stk.pop();
                res.push_back(stk.top()->val);
                stk.pop();
                continue;
            }
            stk.push(nullptr);
            if (node->right) {
                stk.push(node->right);
            }
            if (node->left) {
                stk.push(node->left);
            }
        }
        return res;
    }
};

