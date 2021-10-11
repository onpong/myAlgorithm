//做法一：已经压缩过空间了
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int[] temp0 = help(strs[0]);
        for(int i = 0;i < m + 1;i++){
            for(int j = 0;j < n + 1;j++){
                if(temp0[0] <= i && temp0[1] <= j){
                    dp[i][j] = 1;
                }
            }
        }
        for(int i = 1;i < strs.length;i++){
            int[] temp = help(strs[i]);
            for(int j = m;j >= temp[0];j--){
                for(int k = n;k >= temp[1];k--){
                    dp[j][k] = Math.max(dp[j - temp[0]][k - temp[1]] + 1,dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }
    
    public int[] help(String s){
        int[] temp = new int[2];
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '0')
                temp[0]++;
            else
                temp[1]++;    
        }
        return temp;
    }
}
//做法二：对做法一进行优化
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0;i < strs.length;i++){
            int[] temp = help(strs[i]);
            for(int j = m;j >= temp[0];j--){
                for(int k = n;k >= temp[1];k--){
                    dp[j][k] = Math.max(dp[j - temp[0]][k - temp[1]] + 1,dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }

    public int[] help(String s){
        int[] temp = new int[2];
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '0')
                temp[0]++;
            else
                temp[1]++;    
        }
        return temp;
    }
}