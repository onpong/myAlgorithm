
class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    boolean[] visited;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int sum = 0;
        visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        dfs(candidates,target,sum,0);
        return res;
    }
    public void dfs(int[] candidates,int target,int sum,int start){
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        if(sum > target){
            return;
        }
        for(int i = start;i < candidates.length;i++){
            if(i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]){
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            visited[i] = true;
            dfs(candidates,target,sum,i + 1);
            sum -= candidates[i];
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}