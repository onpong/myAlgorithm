import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int right = points[0][1];
        int arrowNum = 1;
        for(int i = 1;i < points.length;i++){
            if(points[i][0] <= right){
                if(points[i][1] <= right)
                    right = points[i][1];
                else
                    continue;
            }else{
                arrowNum++;
                right = points[i][1];
            }
        }
        return arrowNum;
    }
}