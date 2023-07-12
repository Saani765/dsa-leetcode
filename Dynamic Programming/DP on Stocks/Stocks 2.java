// class Solution {
//     public int maxProfit(int[] prices) {
        
//         int n=prices.length;
//         return solve(prices,0,1,n);
//     }
//     private int solve(int[] prices,int ind,int buy,int n)
//     {   int[][] t=new int [ind+1][buy+1];
//         for(int[] row:t) Arrays.fill(row,-1);
//         if(t[ind][buy]!=-1) return t[ind][buy];
//         if(ind==n) return 0;
//          int profit=0;
//         if(buy==1)
//         {profit=Math.max(-prices[ind]+solve(prices,ind+1,0,n),solve(prices,ind+1,1,n));}
//         else  {profit=Math.max(prices[ind]+solve(prices,ind+1,1,n),solve(prices,ind+1,0,n));}
//         return t[ind][buy]=profit;


//     }
// }

//Recurive and Memoized solution failing on 199th and 200th testcase TLE


//Tabulated solution

import java.util.Arrays;

class Solution {

    public int maxProfit(int[] prices) {
        return helperTab(prices);
    }


public int helperTab(int[] prices){
        int[][] dp = new int[prices.length + 1][2];
        for(int[] row : dp) Arrays.fill(row, 0);

        for(int index = prices.length - 1; index >= 0; index--){
            for(int buy = 0; buy < 2; buy++){
                int totalProfit = 0;
                if(buy == 1){
                    int buyKaro = -prices[index] + dp[index + 1][0];
                    int skipKaro = dp[index + 1][1];
                    totalProfit = Math.max(buyKaro, skipKaro);
                }else{
                    int sellKaro = prices[index] + dp[index + 1][1];
                    int skipKaro = dp[index + 1][0];
                    totalProfit = Math.max(sellKaro, skipKaro);
                }
                dp[index][buy] = totalProfit;
            }
        }
        return dp[0][1];
    }
}