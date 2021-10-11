class Solution {
    public boolean judgeSquareSum(int c) {
        double left = 0;
        double right = (int)Math.sqrt(c);
        while(left <= right){
            if(left * left + right * right < c)
                left++;
            else if(left * left + right * right > c)
                right--;
            else 
                return true;
        }
        return false;
    }
}