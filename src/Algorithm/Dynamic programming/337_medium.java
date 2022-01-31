class Solution {
    Map<TreeNode,Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        return help(root);
    }
    public int help(TreeNode root){
        if(root == null)
            return 0;
        if(map.containsKey(root))
            return map.get(root);
        int money = root.val;
        if(root.left != null)
            money += help(root.left.left) + help(root.left.right);
        if(root.right != null)
            money += help(root.right.left) + help(root.right.right);
        map.put(root,Math.max(money,help(root.left) + help(root.right)));
        return Math.max(money,help(root.left) + help(root.right));
    }
}