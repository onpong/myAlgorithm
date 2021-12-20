/**
 * O(N)
 * O(1)
 */
class Solution {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for(int i = 1;i < n;i++){
            ans = (ans + m) % (i + 1);
        }
        return ans;
    }
}