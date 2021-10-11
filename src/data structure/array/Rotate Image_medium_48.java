//方法一：分奇偶两种情况讨论：
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n % 2 == 0){
            int start = 0;
            while(start <= (n / 2 - 1)){
                for(int i = start;i < n - start - 1;i++){    
                    changePosition(matrix,start,i,n);
                }
                start++;
            }
        }else{
            int start = 0;
            while(start <= n / 2){
                for(int i = start;i < n - start - 1;i++){
                    changePosition(matrix,start,i,n);
                }
                start++;
            }
        }
    }
    public void changePosition(int[][] matrix,int start,int i,int n){
        int top = matrix[start][i];
        int right = matrix[i][n - start - 1];
        int bottom = matrix[n - start - 1][n - i - 1];
        int left = matrix[n - i - 1][start];
        matrix[n - i - 1][start] = bottom;
        matrix[n - start - 1][n - i - 1] = right;
        matrix[i][n - start - 1] = top;
        matrix[start][i] = left;
    }
}

//方法二：利用偏移量
  public void rotate(int[][] matrix) {
        int add = 0;
        int temp = 0;
        int pos1 = 0;
        int pos2 = matrix[0].length - 1;
        while (pos1 < pos2){
            add = 0;
            while (add < pos2 - pos1){
                temp = matrix[pos1][pos1 + add];
                matrix[pos1][pos1 + add] = matrix[pos2 - add][pos1];
                matrix[pos2 - add][pos1] = matrix[pos2][pos2 -add];
                matrix[pos2][pos2 -add] = matrix[pos1 + add][pos2];
                matrix[pos1 + add][pos2] = temp;
                add++;
            }
            pos1++;
            pos2--;


        }
    }