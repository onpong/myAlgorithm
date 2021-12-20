//做法一。回溯法实际上是基于深度优先搜索的，可以以树的思想来理解
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();//记载遍历过程中的路径
        int depth = 0;
        boolean[] used = new boolean[nums.length];//记载节点是否已经被访问
        dfs(nums,res,path,depth,used);
        return res;
    }
    public void dfs(int[] nums,List<List<Integer>> res, List<Integer> path,int depth,boolean[] used){
        if(depth == used.length){//如果当前遍历的深度和树高一样那么说明当前路径可以被加入答案。
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(!(used[i])){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,res,path,depth + 1,used);
                used[i] = false;//回溯法修改状态
                path.remove(path.size() - 1);//回溯法修改状态
            }
        }

    }
}