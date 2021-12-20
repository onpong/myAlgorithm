//做法一：
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        int[] visited = new int[isConnected.length];
        for(int i = 0;i < visited.length;i++){
            if(visited[i] == 0){
                dfs(i,isConnected,visited);
                res++;
            }
        }
        return res;
    }
    public void dfs(int i,int[][] isConnected,int[] visited){
        visited[i] = 1;
        for(int j = 0;j < isConnected[i].length;j++){
            if(isConnected[i][j] == 1 && visited[j] == 0){
                dfs(j,isConnected,visited);
            }
        }
    }
}