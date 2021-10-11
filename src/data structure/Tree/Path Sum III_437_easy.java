/**
 * 方法1
 * O(N2)
 * O(N)
 */
class Solution {
    private ArrayList<Integer> list = new ArrayList<>();
    private int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        //先序遍历，设置一个集合来保存当前遍历过的所有路径之和。
        //遍历到一个元素的时候，先看这个元素是不是targetSum，如果是，res++，
        //如果不是，那么把集合中的所有元素加上当前遍历这个节点的值表示所有路径的和的变化
        //当一个节点的孩子都遍历完准备回溯的时候，要将集合中所有元素减去这个节点的值
        preOrder(root,targetSum);
        return res;
    }
    public void preOrder(TreeNode node,int targetSum){
        if(node == null)
            return;
        //将集合中所有元素加上这个元素表示路径和的变化，最后将这个元素也加入集合
        for(int i = 0;i < list.size();i++){
            list.set(i,list.get(i) + node.val);
            if(list.get(i) == targetSum){
                res++;
            }
        }
        list.add(node.val);
        if(node.val == targetSum)
            res++;
        preOrder(node.left,targetSum);
        preOrder(node.right,targetSum);
        //当一个节点的孩子都遍历完准备回溯的时候，要将集合中所有元素减去这个节点的值
        list.remove(list.size() - 1);
        for(int i = 0;i < list.size();i++){
            list.set(i,list.get(i) - node.val);
        }
        
        
    }
}
/**
 * 方法2
 * O(N)
 * O(N)
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        // key是前缀和, value是大小为key的前缀和出现的次数
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // 前缀和为0的一条路径
        prefixSumCount.put(0, 1);
        // 前缀和的递归回溯思路
        return recursionPathSum(root, prefixSumCount, sum, 0);
    }

    /**
     * 前缀和的递归回溯思路
     * 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
     * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
     * @param node 树节点
     * @param prefixSumCount 前缀和Map
     * @param target 目标值
     * @param currSum 当前路径和
     * @return 满足题意的解
     */
    private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount, int target, int currSum) {
        // 1.递归终止条件
        if (node == null) {
            return 0;
        }
        // 2.本层要做的事情
        int res = 0;
        // 当前路径上的和
        currSum += node.val;

        //---核心代码
        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        res += prefixSumCount.getOrDefault(currSum - target, 0);
        // 更新路径上当前节点前缀和的个数
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        //---核心代码

        // 3.进入下一层
        res += recursionPathSum(node.left, prefixSumCount, target, currSum);
        res += recursionPathSum(node.right, prefixSumCount, target, currSum);

        // 4.回到本层，恢复状态，去除当前节点的前缀和数量
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
        return res;
    }
}

