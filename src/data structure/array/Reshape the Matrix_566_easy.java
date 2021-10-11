//O(M*N)
//空间复杂度O(1)，不算返回的结果。
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int total = r * c;
        if(mat.length * mat[0].length != total){
            return mat;
        }
        int[][] res = new int[r][c];
        int indexR = 0;
        int indexC = 0;
        for(int i = 0; i < mat.length;i++){
            for(int j = 0;j < mat[0].length;j++){
                res[indexR][indexC] = mat[i][j];
                if(++indexC == c){
                    indexC = 0;
                    indexR++;
                }
            }
        }
        return res;
    }
}