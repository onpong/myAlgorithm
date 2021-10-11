//方法一：
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = 0;
        int rightStop = matrix[0].length;
        while(row < matrix.length){
            while(col < rightStop){
                if(matrix[row][col] < target){
                    col++;
                    continue;
                }
                if(matrix[row][col] > target){
                    rightStop = col;
                    break;
                }
                if(matrix[row][col] == target){
                    return true;
                }
            }
            row++;
            col = 0;
        }
        return false;
    }
}
//方法二：
//从右上角遍历，若元素大于当前值，则向下移动，否则向左移动。类似于二叉搜索树。妙啊！！！！！
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 )
            return false;

        int left=0;
        int right=matrix[0].length-1;

        while (left<matrix.length && right>=0){

            if(matrix[left][right]==target)
                return true;
            else if(matrix[left][right]>target){
                right--;
            }else{
                left++;
                }
        }
        return false;
    }
}