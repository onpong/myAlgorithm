/**
 * O(N)
 * O(N)
 */
class Solution {
    public int trap(int[] height) {
        //遍历每一个节点h，找到左右两边最高的l,r，取短的一边，假设r短
        //那么在这个位置上的雨水单位就是(r - h)
        
        //先遍历两遍，得出每个位置左右两边最高点
        int[][] highest = new int[height.length][2];
        int l = 0;
        int r = 0;
        for(int i = 0;i < height.length;i++){
            highest[i][0] = l;
            l = Math.max(l,height[i]);
        }
        for(int i = height.length - 1;i >= 0;i--){
            highest[i][1] = r;
            r = Math.max(r,height[i]);
        }
        int res = 0;
        for(int i = 1;i < height.length;i++){
            if(highest[i][0] > height[i] && highest[i][1] > height[i]){
                res += Math.min(highest[i][0],highest[i][1]) - height[i];
            }
        }
        return res;
    }
}
/**
 * 优化空间
 * O(N)
 * O(1)
 */
public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int ans = 0;
    int left_max = 0, right_max = 0;
    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] >= left_max) {
                left_max = height[left];
            } else {
                ans += (left_max - height[left]);
            }
            ++left;
        } else {
            if (height[right] >= right_max) {
                right_max = height[right];
            } else {
                ans += (right_max - height[right]);
            }
            --right;
        }
    }
    return ans;
}

