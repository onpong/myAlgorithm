public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0;i < 32;i++){
            int temp = n & 1;
            res = res << 1;
            res += temp;   
            n = n >> 1;
        }
        return res;
       
    }
}