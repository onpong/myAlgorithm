class Solution {
    public int numSquares(int n) {
        int[] res = new int[n + 1];
        for(int i = 1;i <= n;i++){
            res[i] = i;
            for(int j = 1;i - j * j >= 0;j++){
                res[i] = Math.min(res[i],res[i - j * j] + 1);
            }
        }
        return res[n];
    }
}