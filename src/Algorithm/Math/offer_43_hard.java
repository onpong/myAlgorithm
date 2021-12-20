/**
 * logn(因为实际上是log10n)
 * O(1)
 */
class Solution {
    public int countDigitOne(int n) {
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        int digit = 1;
        int res = 0;
        while(high != 0 || cur != 0){
            if(cur == 0){
                res += high * digit;
            }else if(cur == 1){
                res += high * digit + 1 + low;
            }else{
                res += (high + 1) * digit;
            }
            low = cur * digit + low;
            cur = high % 10;
            high = high / 10;
            digit *= 10;
        }
        return res;
    }
}