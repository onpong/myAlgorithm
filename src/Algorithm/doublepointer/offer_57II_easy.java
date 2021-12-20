/**
 * O(N)
 * O(N)
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        int slow = 1;
        int fast = 1;
        int sum = 1;
        ArrayList<int[]> res= new ArrayList<>();
        while(fast <= target / 2 + 1){
            if(sum == target){
                int[] temp = new int[fast - slow + 1];
                for(int i = slow;i <= fast;i++){
                    temp[i - slow] = i;
                }
                res.add(temp);
                fast++;
                sum += fast;
            }else if(sum > target){
                sum -= slow;
                slow++;
            }else{
                fast++;
                sum += fast;
            }

        }
        return res.toArray(new int[res.size()][]);
    }

}