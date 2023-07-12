class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n][2][3];
        for(int r[][]:dp)
            for(int d[]:r)Arrays.fill(d,-1);
        return f(0,2,0,dp,n,prices);
    }
    public int f(int ind,int cap,int status,int dp[][][],int n,int p[])
    {
        if(ind==n || cap==0)return 0;
        if(dp[ind][status][cap]!=-1)return dp[ind][status][cap];
        int profit;
        if(status==0)
        {
            int a = f(ind+1,cap,0,dp,n,p);
            int b = -p[ind] + f(ind+1,cap,1,dp,n,p);
            profit = (int)Math.max(a,b);
        }
        else
        {
            int c = f(ind+1,cap,1,dp,n,p);
            int d = p[ind] + f(ind+1,cap-1,0,dp,n,p);
            profit = (int)Math.max(c,d);
        }
        return dp[ind][status][cap]=profit;
    }
}