//动态规划
//O(N2)
//O(N2)
class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        int left = 0;
        int right = 0;
        for(int i = s.length() - 1;i >= 0;i--){
            for(int j = i; j< s.length();j++){
                if(i == j){
                    dp[i][j] = true;
                    continue;
                }
                if(s.charAt(i) == s.charAt(j)){
                    if(i + 1 == j){
                        dp[i][j] = true;            
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if(dp[i][j] && j - i + 1 > res){
                        res = j - i + 1;
                        left = i;
                        right = j;          
                }
            }
        }
    }
    return res == 1 ? "" + s.charAt(0) : s.substring(left,right + 1);
}
}
//中心扩散法
//O(N2)
//O(1)
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
}

