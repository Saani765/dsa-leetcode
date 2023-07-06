class Solution {
    public int coinChange(int[] coins, int sum) {
        int n=coins.length;
        int[][] t = new int[n+1][sum+1];
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(i==0) t[i][j]=Integer.MAX_VALUE-1;
                if(j==0) t[i][j]=0;
            }
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=0;j<sum+1;j++)
            {
                if(j%coins[0]==0) t[i][j]=j/coins[0];
                else
                t[i][j]=Integer.MAX_VALUE-1;     
            }
        }
        for(int i=2;i<n+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(coins[i-1]<=j)
                t[i][j]=Math.min(t[i-1][j],t[i][j-coins[i-1]]+1);
                else 
                t[i][j]=t[i-1][j];     
            }
        }
        return (t[n][sum]==Integer.MAX_VALUE-1) ? -1: t[n][sum];

    }
}