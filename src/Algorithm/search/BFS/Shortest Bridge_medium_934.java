//做法一：
class Solution {
    private LinkedList<int[]> path = new LinkedList<int[]>();
    public int shortestBridge(int[][] grid) {
        int r = 0;
        int c = 0;
        int ans = 0;
        int[][] offset = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        for(int i = 0;i < grid.length;i++){
            boolean out = false;
            for(int j = 0;j < grid[i].length;j++){//找到深度优先搜素开始的地方
                if(grid[i][j] == 1){
                    r = i;
                    c = j;
                    out = true;
                    break;
                }
            }
            if(out)
                break;
        }
        dfs(path,grid,r,c);
        while(path.size() != 0){
            int len = path.size();
            while(len-- > 0){//队列原有元素每清空一次，答案加1.
                int[] location = path.poll();
                int x = location[0];
                int y = location[1];
                for(int k = 0;k < 4;k++){//广度优先搜索
                    int newX = x + offset[k][0];
                    int newY = y + offset[k][1];
                    if(newX < 0 || newX > grid.length - 1 || newY < 0 || newY > grid[newX].length - 1)
                        continue;
                    if(grid[newX][newY] == 2)
                        continue;
                    if(grid[newX][newY] == 1)
                        return ans;
                    grid[newX][newY] = 2;
                    path.add(new int[]{newX,newY});
                }
            }
            ans++;
        }
       return ans;
    }
    public void dfs(List path,int[][] grid,int r,int c){
        if(!(r >= 0 && r <= grid.length - 1 && c >= 0 && c <= grid[r].length - 1))
            return;
        if(grid[r][c] == 0 || grid[r][c] == 2)
            return;
        grid[r][c] = 2;
        path.add(new int[]{r,c});
        dfs(path,grid,r - 1,c);
        dfs(path,grid,r + 1,c);
        dfs(path,grid,r,c - 1);
        dfs(path,grid,r,c + 1);
    }
}