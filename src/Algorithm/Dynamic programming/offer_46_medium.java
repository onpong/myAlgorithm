/**
 * O(N)
 * O(N)，字符串占用了空间
 */
class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 1;i < s.length();i++){
            int temp = Integer.parseInt("" + s.charAt(i - 1) + s.charAt(i));
            if(s.charAt(i - 1) == '0' || temp > 25){
                dp[i + 1] = dp[i];
            }else if(temp > 0 && temp <= 25){
                dp[i + 1] = dp[i] + dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
/**
 * 空间压缩后
 * O(N)
 * O(N)
 */
class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int pre = 1;
        int cur = 1;
        int a;
        for(int i = 1;i < s.length();i++){
            int temp = Integer.parseInt("" + s.charAt(i - 1) + s.charAt(i));
            if(s.charAt(i - 1) == '0' || temp > 25){
               pre = cur;
            }else if(temp > 0 && temp <= 25){
                a = cur;
                cur = pre + cur;
                pre = a;
            }
        }
        return cur;
    }
}
/**
 * 利用求余
 * O(N)
 * O(1)
 */
class Solution {
    public int translateNum(int num) {
        int a = 1, b = 1, x, y = num % 10;
        while(num != 0) {
            num /= 10;
            x = num % 10;
            int tmp = 10 * x + y;
            int c = (tmp >= 10 && tmp <= 25) ? a + b : a;
            b = a;
            a = c;
            y = x;
        }
        return a;
    }
}

