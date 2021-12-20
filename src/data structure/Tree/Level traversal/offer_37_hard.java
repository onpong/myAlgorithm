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
 * 序列化：层序遍历统计节点，空节点用#表示，节点之间的值用“，”隔开  O(N),O(N)
 * 反序列化：列用offset偏移量构建出树  O(N) O(N)  
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return null;
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        while(!list.isEmpty()){
            TreeNode temp = list.poll();
            if(temp == null){
                res.append("#");
                res.append(",");
                continue;
            }   
            else{
                res.append(temp.val);
                res.append(",");
            }
            list.add(temp.left);
            list.add(temp.right);
        }

        return res.substring(0,res.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null)
            return null;
        String[] array = data.split(",");
        TreeNode res = new TreeNode();
        TreeNode root;
        TreeNode left;
        TreeNode right;
        int offset = 1;
        TreeNode[] temp = new TreeNode[array.length];
        for(int i = 0;i < array.length;i++){
            if(array[i].equals("#"))
                temp[i] = null;
            else{
                temp[i] = new TreeNode(Integer.parseInt(array[i]));
            }   
        }
        for(int i = 0;i < temp.length;i++){
            if(temp[i] == null)
                continue;
            temp[i].left = temp[offset];
            temp[i].right = temp[offset + 1];
            offset += 2;
        }
        return temp[0];
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));