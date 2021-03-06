//
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 1;i < word1.length() + 1;i++){
            for(int j = 1;j < word2.length() + 1;j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }
}

//空间优化
class Solution {
    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        for(int i = 1;i < word1.length() + 1;i++){
            int upleft = 0;
            for(int j = 1;j < word2.length() + 1;j++){
                int temp = dp[j];
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[j] = upleft + 1;
                }else{
                    dp[j] = Math.max(dp[j],dp[j - 1]);
                }
                upleft = temp;

            }
        }
        return word1.length() + word2.length() - 2 * dp[word2.length()];
    }
}