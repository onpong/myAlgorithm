//做法一：
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        boolean[] used = new boolean[n];
        int depth = 0;
        dfs(res,path,used,depth,n,k,0);
        return res;
    }
    public void dfs( List<List<Integer>> res,List<Integer> path,boolean[] used,int depth,int n,int k,int j){
        if(depth == k){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = j;i < n;i++){
            if(!(used[i])){
                path.add(i + 1);
                used[i] = true;
                dfs(res,path,used,depth + 1,n,k,j + 1);
                used[i] = false;
                path.remove(path.size() - 1);
                j+=1;
            }
        }
    }
}
//做法二：进行了剪枝
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        boolean[] used = new boolean[n];
        int depth = 0;
        dfs(res,path,used,depth,n,k,0);
        return res;
    }
    public void dfs( List<List<Integer>> res,List<Integer> path,boolean[] used,int depth,int n,int k,int j){
        if(depth == k){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = j;i < n - (k - path.size()) + 1;i++){//只有这里和上处不同。
            if(!(used[i])){
                path.add(i + 1);
                used[i] = true;
                dfs(res,path,used,depth + 1,n,k,j + 1);
                used[i] = false;
                path.remove(path.size() - 1);
                j+=1;
            }
        }
    }
}