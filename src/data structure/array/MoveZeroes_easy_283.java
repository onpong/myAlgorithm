package array;

public class MoveZeroes_easy_283 {
    public void moveZeroes(int[] nums) {
        int i,j;
        i=0;
        for(j=0;j<nums.length;j++){
            if(nums[j]!=0){
                if(i!=j){//如果不加这个判断语句，那么当i等于j时，下面这种交换方式会出错。
                    nums[i]=nums[i]^nums[j];
                    nums[j]=nums[i]^nums[j];
                    nums[i]=nums[i]^nums[j];
                }
                i++;
            }
        }
    }
}
