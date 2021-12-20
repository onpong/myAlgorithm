/**
 * 不考虑大数问题
 * O(10n次方)
 * O(1)
 */
class Solution {
    public int[] printNumbers(int n) {
        int size = 0;
        for(int i = 0;i < n;i++){
            size = size * 10 + 9;
        }
        int[] res = new int[size];
        res[0] = 1;
        for(int i = 1 ;i < size;i++){
            res[i] = res[i - 1] + 1;
        }
        return res;
    }
}
/**
 * 考虑大数问题怎么做？
 */
