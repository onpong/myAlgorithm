class Solution{
	public int maxProfit(int[] prices){
		int profit = 0;
		for(int i = 0;i < prices.length - 1;i++){
			profit = profit - prices[i];
			if(prices[i + 1] > prices[i]){
				profit = profit + prices[i + 1] - prices[i];
			}else{
				profit = profit + prices[i];
			}
		}
	}
}