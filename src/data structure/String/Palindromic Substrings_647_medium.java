//暴力法
//O(N3)
//O(1)
class Solution {
    public int countSubstrings(String s) {
        int ans = s.length();
        for(int i = 0;i < s.length() - 1;i++){
            for(int j = i + 1;j < s.length();j++){
                boolean isOk = true;
                int l = i;
                int r = j;
                while(l < r){
                    if(s.charAt(l) != s.charAt(r)){
                        isOk = false;
                        break;
                    }else{
                        l++;
                        r--;
                    }
                }
                if(isOk){
                    ans++;
                }
            }
        }
        return ans;
    }
}
//动态规划
//O(N2)
//O(N2)
class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
       boolean[][] dp = new boolean[s.length()][s.length()];
       for(int i = s.length() - 1;i >= 0;i--){
           for(int j = i ;j < s.length();j++){
               if(i == j){
                   dp[i][j] = true;
                   ans++;
                   continue;
               }
               if(s.charAt(i) == s.charAt(j)){
                   if(i + 1 == j){
                       dp[i][j] = true;
                       ans++;
                   }else{
                       dp[i][j] = dp[i + 1][j - 1];
                   }   
               }
               
           }
       }
       return ans;
    }
}
//中心扩展法：
//O(N2)
//O(1)
class Solution6472 {
    public int countSubstrings(String s) {
        // 中心扩展法
        int ans = 0;
        for (int center = 0; center < 2 * s.length() - 1; center++) {
            // left和right指针和中心点的关系是？
            // 首先是left，有一个很明显的2倍关系的存在，其次是right，可能和left指向同一个（偶数时），也可能往后移动一个（奇数）
            // 大致的关系出来了，可以选择带两个特殊例子进去看看是否满足。
            int left = center / 2;
            int right = left + center % 2;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}

