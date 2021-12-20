class Solution {
    public int add(int a, int b) {
        /**无进位和是异或
        进位和和 与且左移一位相同
         */
         while(b != 0){
             int c = (a & b) << 1;//进位
             a ^= b;//非进位
             b = c;//进位
         }
         return a;

    }
}