/**
 * 注意i > 0 && c[i] == c[i - 1] && !visited[i - 1]这一句的剪枝
 * O(N×N!)
 * O(N×N!)
 */
class Solution {
    private List<String> tempRes = new ArrayList<>();
    private boolean[] visited;
    private char[] c;
    private StringBuilder sb = new StringBuilder();
    public String[] permutation(String s) {
        c = s.toCharArray();
        Arrays.sort(c);
        visited = new boolean[s.length()];
        dfs(0,c);
        String[] res = new String[tempRes.size()];
        for(int i = 0;i < tempRes.size();i++){
            res[i] = tempRes.get(i);
        }
        return res;
    }
    public void dfs(int depth,char[] c){
        if(depth == c.length){
            String temp = sb.toString();
            tempRes.add(temp);
        }
        for(int i = 0;i < c.length;i++){
            if(i > 0 && c[i] == c[i - 1] && !visited[i - 1])
                continue;
            if(!visited[i]){
                sb.append(c[i]);
                visited[i] = true;
                dfs(depth + 1,c);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}
/**
 * 利用了固定位的思想，速度更快无需排序
 * 时间复杂度 O(N!N)O(N!N) ： NN 为字符串 s 的长度；时间复杂度和字符串排列的方案数成线性关系，方案数为N×(N−1)×(N−2)…×2×1 ，
 * 即复杂度为 O(N!)O(N!) ；字符串拼接操作 join() 使用 O(N)；因此总体时间复杂度为 O(N!N) 。
 * 空间复杂度 O(N^2)： 全排列的递归深度为 NN ，系统累计使用栈空间大小为 O(N)O(N) ；
 * 递归中辅助 Set 累计存储的字符数量最多为 N + (N-1) + ... + 2 + 1 = (N+1)N/2N+(N−1)+...+2+1=(N+1)N/2 ，即占用 O(N^2)O(N^2) 的额外空间。
 *
 */
class Solution {
    List<String> res = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) continue; // 重复，因此剪枝
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                      // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }
    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
