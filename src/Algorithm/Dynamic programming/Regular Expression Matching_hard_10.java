//
class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for(int i = 0;i < len2;i++){
            if(p.charAt(i) == '*'){
                dp[0][i + 1] = dp[0][i - 1];
            }
        }
        for(int i = 1;i < len1 + 1;i++){
            for(int j = 1;j < len2 + 1;j++){
                if(p.charAt(j - 1) == '.'){//当前p为.的时候
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(p.charAt(j - 1) != '*'){//当前p为普通字母的时候
                    dp[i][j] = s.charAt(i - 1) == p.charAt(j - 1) ? dp[i - 1][j - 1] : false;
                }else if(p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.'){//当前p为*且p前一个字母和s最后一个字母不匹配且p前一个字母不为.
                    dp[i][j] = dp[i][j - 2];
                }else{
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] || dp[i][j - 1];//当前p为*且p前一个字母和s最后一个字母匹配的时候
                                                                                //分别不匹配，匹配一次，匹配多次的情况。
                }
            }
        }
        return dp[len1][len2];
    }
}