//虽然题目要求的是满足向下流能到达两个大洋的位置，如果我们对所有的位置进行搜索，那
// 么在不剪枝的情况下复杂度会很高。因此我们可以反过来想，从两个大洋开始向上流，这样我们
// 只需要对矩形四条边进行搜索。搜索完成后，只需遍历一遍矩阵，满足条件的位置即为两个大洋
// 向上流都能到达的位置。
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> directions=new ArrayList<List<Integer>>();
        boolean[][] canReachP = new boolean[heights.length][heights[0].length];
        boolean[][] canReachA = new boolean[heights.length][heights[0].length];
        for(int i = 0;i < heights.length;i++){
            dfs(heights,canReachP,i,0);
            dfs(heights,canReachA,i,heights[i].length - 1);
        }
        for(int j = 0;j < heights[0].length;j++){
            dfs(heights,canReachP,0,j);
            dfs(heights,canReachA,heights.length - 1,j);
        }
        for(int i = 0;i < heights.length;i++)
            for(int j = 0;j < heights[i].length;j++){
                if(canReachA[i][j] && canReachP[i][j]){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(i);
                    temp.add(j);
                    directions.add(temp);
                }
            }
        return directions;
    }
    public void dfs(int[][] heights,boolean[][] reach,int r,int c){
        if(!(r >= 0 && r <= heights.length - 1 && c >= 0 && c <= heights[r].length - 1)){
            return;
        }
        if(reach[r][c])
            return;
        reach[r][c] = true;
        if((r - 1) >= 0 && heights[r - 1][c] >= heights[r][c]){
            dfs(heights,reach,r - 1,c);
        }
        if((r + 1) <= heights.length - 1 && heights[r + 1][c] >= heights[r][c]){
            dfs(heights,reach,r + 1,c);
        }
        if((c - 1) >= 0 && heights[r][c - 1] >= heights[r][c]){
            dfs(heights,reach,r,c - 1);
        }
        if((c + 1) <= heights[0].length - 1 && heights[r][c + 1] >= heights[r][c]){
            dfs(heights,reach,r,c + 1);
        }
        
    }
}