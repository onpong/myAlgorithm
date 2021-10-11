//时间复杂度：O(N),空间复杂度O(N)
//先从左到右扫描再从右到左扫描，第一趟扫描是为了保证假如右边孩子比左边孩子评分高
//则能分的更多的糖果。第二趟同理。两趟下来就能保证两个方向的大小关系。
class Solution {
    public int candy(int[] ratings) {
        int[] candynum = new int[ratings.length];
        int ans = 0;
        for(int i = 0;i < ratings.length; i++){//存储糖果的数组初始化
            candynum[i] = 1;
        }
        for(int i = 0;i < ratings.length - 1;i++){//从左到右扫描
            if(ratings[i + 1] > ratings[i]){
                candynum[i + 1] = candynum[i] + 1;
                
            }
        }
        for(int i = ratings.length-1; i > 0;i--){//从右到左扫描
            if(ratings[i - 1] > ratings[i] && candynum[i - 1] <= candynum[i]){
                candynum[i - 1] = candynum[i] + 1;
               
            }
        }
        for(int i = 0;i < candynum.length;i++){//统计糖果最终数量
            ans = ans + candynum[i];
        }
        return ans;
    }
}