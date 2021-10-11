class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length < 2)
            return 0;
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
//这里的 o1[0]-o2[0] 表示按照第一个元素升序排列
// o2[0]-o1[0] 表示按照第一个元素降序排列
// o1[1]-o2[1] 表示按照第二个元素升序排列
        int right = intervals[0][1];
        int ans = 0;
        for(int i = 1;i < intervals.length;i++){
            if(intervals[i][0] >= right){
                right = intervals[i][1];
            }else{
                ans++;
            }
        }
        return ans;
    }
}