/**
 * O(N)
 * O(N)
 */
class Solution {
    public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;
        //按照中序遍历的结果构造
        Node min = inorder(root,0);
        Node temp = min;
        while(temp.right != null){
            temp = temp.right;
        }
        min.left = temp;
        temp.right = min;
        return min;
    }
    public Node inorder(Node root,int isLeft){
        /**
        返回：若是左子树返回最后一个节点，右子树返回第一个节点
        终止：碰到到叶子节点
        每层：先判断该层时左子树还是右子树，
         */
        if(root == null)
            return null;
        Node l = inorder(root.left,1);
        if(l != null){
            l.right = root;
            root.left = l;
        }
        Node r = inorder(root.right,0);
        if(r != null){
            root.right = r;
            r.left = root;
        }
        Node cur = root;
        if(isLeft == 1){
            while(cur.right != null){
                cur = cur.right;
            }
        }else{
            while(cur.left != null){
                cur = cur.left;
            }
        }
        return cur;
    }
}

/**
 * 简化版本
 * 只需要维护一个节点以及他的前驱节点就可以操作了。
 */
class Solution {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}

