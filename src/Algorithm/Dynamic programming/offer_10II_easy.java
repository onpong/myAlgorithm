class Solution {
    public int numWays(int n) {
        if(n == 0)
            return 0;
        int pre = 0;
        int cur = 1;
        int res = 1;
        for(int i = 2;i <= n;i++){
            res = (pre + cur) % 1000000007;//防止溢出
            pre = cur;
            cur = res;
        }
        return res;
    }
}