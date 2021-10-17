class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for(int i = 1;i < parent.length;i++){
            parent[i] = i;
        }
        for(int i = 0;i < edges.length;i++){
            int set1 = find(edges[i][0],parent);
            int set2 = find(edges[i][1],parent);
            if(set1 == set2){
                return edges[i];
            }
            parent[set1] = set2;
        }
        return new int[]{0,0};
    }
    public int find(int a,int[] parent){
        while(parent[a] != a){
            a = parent[a];
        }
        return a;
    }
}