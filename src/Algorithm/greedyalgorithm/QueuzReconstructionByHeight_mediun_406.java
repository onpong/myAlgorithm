import java.util.ArrayList;
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        ArrayList<int[]> ans = new ArrayList<int[]>();
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        for(int i = 0;i < people.length;i++){
            ans.add(people[i][1],people[i]);
        }
        return ans.toArray(new int[people.length][2]);
    }
}