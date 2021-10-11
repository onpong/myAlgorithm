//方法1：优先级队列
//O(N*M*log(N*M))
//O(N*M)
//超时
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> q = new PriorityQueue<>();
        q.add(1L);
        set.add(1L);
        while (n-- > 0) {
            long x = q.poll();
            if (n == 0) return (int)x;
            for (int k : primes) {
                if (!set.contains(k * x)) {
                    set.add(k * x);
                    q.add(k * x);
                }
            }
        }
        return -1; // never
    }
}
//方法2动态规划
//O(NM)
//O(N+M)
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] indexs = new int[primes.length];
        for(int i = 1;i < n;i++){
            dp[i] = Integer.MAX_VALUE;
            int temp = 0;
            for(int j = 0; j < primes.length;j++){
                if(dp[i] > dp[indexs[j]] * primes[j]){
                    dp[i] = dp[indexs[j]] * primes[j];
                    temp = j;
                }
            }
            for(int j = 0; j < primes.length;j++){
                if(dp[i] == dp[indexs[j]] * primes[j]){
                    indexs[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
