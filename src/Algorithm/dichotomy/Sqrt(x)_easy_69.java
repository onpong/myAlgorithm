class Solution {
    public int mySqrt(int x) {
        if( x == 0)
            return 0;
        int left = 1,right = x;
        while(left < right){
            int medium = left + (right - left) / 2;
            int sqrt = x / medium;
            if( medium > sqrt){
                right = medium - 1;
            }else if(medium < sqrt){
                left = medium + 1;
            }else{
                return medium;
            }
        }
        int temp = x / left;
        if(left > temp){
            return left - 1;
        }else{
            return left;
        }
    }
}