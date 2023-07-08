//{ Driver Code Starts
//Initial Template for Java


import java.util.*;



//User function Template for Java

class Solution{
    static int m = 1003;
    static int solve(int i, int j, String s, int tOrF, int dp[][][])
    {
        if(i == j)
        {
            if(tOrF == 1 && s.charAt(i) == 'T')
                return 1;
            if(tOrF == 0 && s.charAt(i) == 'F')
                return 1;
            else
                return 0;
        }
        
        if(i > j)
            return 0;
            
        if(dp[i][j][tOrF] != -1)
            return dp[i][j][tOrF];
          
        int res = 0;    
        for(int k = i+1 ; k <= j-1 ; k+=2)
        {
                char op = s.charAt(k); 
                int lt = solve(i, k-1, s, 1, dp);
                int lf = solve(i, k-1, s, 0, dp);
                int rt = solve(k+1, j, s, 1, dp);
                int rf = solve(k+1, j, s, 0, dp);
                if(op == '|')
                {
                    if(tOrF == 1){
                        res += (lt*rt)%m;
                        res += (lt*rf)%m;
                        res += (lf*rt)%m;
                    }else{
                        res += (lf*rf)%m;
                    }
                }else if(op == '&')
                {
                    if(tOrF == 1){
                        res += (lt*rt)%m;
                    }else{
                        res += (lf*rt)%m;
                        res += (lt*rf)%m;
                        res += (lf*rf)%m;
                    }
                }
                else{
                    if(tOrF == 1){
                        res += (lt*rf)%m;
                        res += (lf*rt)%m;
                    }else{
                        res += (lt*rt)%m;
                        res += (lf*rf)%m;
                    }
                }
        }
        return dp[i][j][tOrF] = res%m;
    }
    static int countWays(int N, String S){
        // code here
        int dp[][][] = new int[N][N][2];
        for(int mat[][] : dp)
            for(int row[] : mat)
                Arrays.fill(row, -1);
        return solve(0, N-1, S, 1, dp);
    }
}