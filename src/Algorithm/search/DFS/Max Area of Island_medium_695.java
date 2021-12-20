//做法一：沉岛思想
//
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0;i < grid.length;i++)
            for(int j = 0;j < grid[i].length;j++){
                if(grid[i][j] == 1){
                    res = Math.max(res,dfs(grid,i,j));
                }
            }
        return res;
    }
    public int dfs(int[][] grid, int r, int c){
        if(!(r >=0 && r <= grid.length - 1 && c>=0 && c <= grid[0].length - 1 && grid[r][c] == 1)){
            return 0;
        }
        int nums = 1;
        grid[r][c] = 0;
        nums += dfs(grid, r + 1,c);
        nums += dfs(grid, r - 1,c);
        nums += dfs(grid, r ,c + 1);
        nums += dfs(grid, r ,c - 1);
        return nums;
    }
}