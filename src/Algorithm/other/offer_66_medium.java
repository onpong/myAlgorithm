/**
 * O(N)
 * O(N)
 */

class Solution {
    public int[] constructArr(int[] a) {
        if(a.length == 0)
            return new int[]{};
        int[] b = new int[a.length];
        b[0] = 1;
        for(int i = 1;i < a.length;i++){
            b[i] = b[i - 1] * a[i - 1];
        }
        int temp = 1;
        for(int i = a.length - 1;i >= 0;i--){
            b[i] *= temp;
            temp *= a[i];
        }
        return b;
    }
}