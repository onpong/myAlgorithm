/**
 * O(MN)
 * O(1)
 * 从右下角开始遍历，得出每个点所能选取的最大礼物价值
 */
class Solution {
    public int maxValue(int[][] grid) {
        //动态规划
        for(int i = grid.length - 1;i >= 0 ;i--){
            for(int j = grid[i].length - 1;j >= 0;j--){
                if(i == grid.length - 1 && j == grid[i].length - 1){
                    continue;
                }else if(i == grid.length - 1){
                    grid[i][j] = grid[i][j + 1] + grid[i][j];
                }else if(j == grid[i].length - 1){
                     grid[i][j] = grid[i + 1][j] + grid[i][j];
                }else{
                    grid[i][j] = Math.max(grid[i][j + 1],grid[i + 1][j]) + grid[i][j];
                }
            }
        }
        return grid[0][0];
    }
}