class Solution {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int sum = 0;
        int p = 1;
        int q = 2;
       for(int i = 3;i <= n;i++){
           sum = p + q;
           p = q;
           q = sum;
       }
       return sum;
    }
   
}