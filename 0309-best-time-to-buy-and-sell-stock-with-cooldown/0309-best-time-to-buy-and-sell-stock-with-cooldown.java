// class Solution {
//     public int maxProfit(int[] prices) {
//         return solve(prices,0,1);
//     }
//     private int solve(int[] prices,int day,int buy)
//     {   int[][] t=new int[day+1][buy+1];
//         for(int[] row :t) Arrays.fill(row,-1);
//         int n=prices.length;
//         if(day>=n) return 0;
//         if(t[day][buy]!=-1) return t[day][buy];
//         if(buy==1)
//         {
//             return t[day][buy]=Math.max(-prices[day]+solve(prices,day+1,0),solve(prices,day+1,1));
//         }
//         else
//         {
//             return t[day][buy]=Math.max(prices[day]+solve(prices,day+2,1),solve(prices,day+1,0));
//         }

//     }
// }

//Recursion and Memoized Solution giving TLE on last 4 cases 

class Solution {
    //Tabulation solution
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int dp[][] = new int[n+2][2];

        for(int index = n-1;index >= 0;index--){
            for(int buy = 0;buy <= 1;buy++){
                if(buy == 1){
                    dp[index][buy] = Math.max( -prices[index] + dp[index + 1][0] , 
                                                  0 + dp[index +1][1]);
                }
                else{
                    dp[index][buy] = Math.max(prices[index] + dp[index + 2][1] , 
                                                 0 + dp[index + 1][0]);
                }
            }
        }

        return dp[0][1];
    }
}