class Solution {
    private boolean[] col;
    private boolean[] main;
    private boolean[] vice;
    private List<Integer> path = new ArrayList<>();
    private List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        main = new boolean[2 * n - 1];
        vice = new boolean[2 * n - 1];
        dfs(0,n);
        return res;
    }
    public void dfs(int r,int n){
        if(path.size() == n){
            res.add(combination(n));
        }
        for(int c = 0;c < n;c++){
            if(!(col[c] || main[r - c + n - 1] || vice[r + c])){
                path.add(c);
                col[c] = true;
                main[r - c + n - 1] = true;
                vice[r + c] = true;
                dfs(r + 1,n);
                col[c] = false;
                main[r - c + n - 1] = false;
                vice[r + c] = false;
                path.remove(path.size() - 1);
            }
        }
    }
   

    public List combination(int n){
        List<String> temp = new ArrayList<>();
         for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            row.append(".".repeat(n));
            row.replace(num, num + 1, "Q");
            temp.add(row.toString());
        }
        return temp;
    }
}