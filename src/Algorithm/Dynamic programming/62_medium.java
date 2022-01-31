/**
 * O(M*N)
 * O(M*N)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0;i < n;i++){
            dp[m - 1][i] = 1;
        }
        for(int i = 0;i < m;i++){
            dp[i][n - 1] = 1;
        }
        for(int i = m - 1;i >= 0;i--){
            for(int j = n - 1;j >= 0;j--){
                if(i + 1 >= m || j + 1 >= n)
                    continue;
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}
/**
 * 空间优化
 * O(M*N)
 * O(N)
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = m - 1;i >= 0;i--){
            for(int j = n - 1;j >= 0;j--){
                if(i + 1 >= m || j + 1 >= n)
                    continue;
                dp[j] = dp[j] + dp[j + 1];
            }
        }
        return dp[0];
    }
}