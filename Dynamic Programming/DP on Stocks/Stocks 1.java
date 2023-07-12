class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n=prices.length;
        int[] t=new int[n+1];
        t[0]=prices[0];
        for(int i=1;i<n;i++)
        {
            t[i]=Math.min(t[i-1],prices[i]);
        }
        for(int i=0;i<n;i++)
        {
            profit=Math.max(profit,prices[i]-t[i]);
        }
        return profit;
    }
}
