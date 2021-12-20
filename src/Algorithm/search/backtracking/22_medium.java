class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        int left = n;
        int right = n;
        StringBuilder s = new StringBuilder();
        dfs(left,right,s);
        return res;
    }
    public void dfs(int left,int right,StringBuilder s){
        if(left > right)
            return;
        if(left == 0 && right == 0){
            res.add(s.toString());
            return;
        }
        if(left > 0){
            s.append('(');
            dfs(left - 1,right,s);
            s = s.deleteCharAt(s.length() - 1);
        }
        s.append(")");
        dfs(left,right - 1,s);
        s = s.deleteCharAt(s.length() - 1);
    }
}