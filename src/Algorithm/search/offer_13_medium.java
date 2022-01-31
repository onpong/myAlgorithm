/**
 * 方法1,深度优先
 * O(M * N)
 * O(M * N)
 */
class Solution {
    private int res = 0;
    private boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        help(m,n,k,0,0);
        return res;
    }
    public void help(int m ,int n, int k,int r,int c){
        if(r < 0 || r > m - 1 || c < 0 || c > n - 1){
            return;
        }
        if(visited[r][c])
            return;
        int sum = sum(r,c);
        if(sum > k)
            return;
        res += 1;
        visited[r][c] = true;
        help(m,n,k,r,c - 1);//只需要向下和向右
        help(m,n,k,r,c + 1);
    }
    public int sum(int m,int n){
        int res = 0;
        while(m != 0){
            res += m % 10;
            m = m / 10;
        }
        while(n != 0){
            res += n % 10;
            n = n / 10;
        }
        return res;
    }
}
/**
 * 广度优先
 * O(M * N)
 * O(M * N)
 */
public int movingCount(int m, int n, int k) {
    //临时变量visited记录格子是否被访问过
    boolean[][] visited = new boolean[m][n];
    int res = 0;
    //创建一个队列，保存的是访问到的格子坐标，是个二维数组
    Queue<int[]> queue = new LinkedList<>();
    //从左上角坐标[0,0]点开始访问，add方法表示把坐标
    // 点加入到队列的队尾
    queue.add(new int[]{0, 0});
    while (queue.size() > 0) {
        //这里的poll()函数表示的是移除队列头部元素，因为队列
        // 是先进先出，从尾部添加，从头部移除
        int[] x = queue.poll();
        int i = x[0], j = x[1];
        //i >= m || j >= n是边界条件的判断，k < sum(i, j)判断当前格子坐标是否
        // 满足条件，visited[i][j]判断这个格子是否被访问过
        if (i >= m || j >= n || k < sum(i, j) || visited[i][j])
            continue;
        //标注这个格子被访问过
        visited[i][j] = true;
        res++;
        //把当前格子下边格子的坐标加入到队列中
        queue.add(new int[]{i + 1, j});
        //把当前格子右边格子的坐标加入到队列中
        queue.add(new int[]{i, j + 1});
    }
    return res;
}

//计算两个坐标数字的和
private int sum(int i, int j) {
    int sum = 0;
    while (i != 0) {
        sum += i % 10;
        i /= 10;
    }
    while (j != 0) {
        sum += j % 10;
        j /= 10;
    }
    return sum;
}

