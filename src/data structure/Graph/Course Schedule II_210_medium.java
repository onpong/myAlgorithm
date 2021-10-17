/**
 * O(E+V)
 * O(V)
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        HashSet<Integer>[] pre = new HashSet[numCourses];
        for(int i = 0;i < numCourses;i++){
            pre[i] = new HashSet<>();
        }
        int[] inDegree = new int[numCourses];
        for(int i = 0;i < prerequisites.length;i++){
            pre[prerequisites[i][1]].add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < inDegree.length;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            res[count++] = temp;
            HashSet<Integer> set = pre[temp];
            for(Integer j : set){
                if(--inDegree[j] == 0){
                    queue.add(j);
                }
            }
            
        }
        if(count == numCourses)
            return res;
        return new int[0];
    }
}