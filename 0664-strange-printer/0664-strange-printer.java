class Solution {
    public int strangePrinter(String s) {
        int[][] dp = new int[s.length()][s.length()]; // dp[i][j] defines minimum turns for substring i to j
      for(int i = dp.length - 1; i >= 0; i--){
        for(int j = 0; j < dp.length; j++){
          if(i > j){ // invalid substring
            continue;
          }else if(i == j){// single character || base condition
            dp[i][j] = 1;
          }else{
            int min = Integer.MAX_VALUE;
            for(int k = i; k < j; k++){ // For finding split which results in minimum turns;
              min = Math.min(min, dp[i][k] + dp[k + 1][j]); 
            }
            if(s.charAt(i) == s.charAt(j)){
              min--;
            }
            dp[i][j] = min;
          }
        }
      }
      return dp[0][s.length() - 1];
      // TC -> O(n ^ 3)
    }
	  // Memoization
    public int solveMemo(String s, int i, int j, Integer[][] dp){
      if(i == j){
        return 1;
      }
      if(dp[i][j] != null){
        return dp[i][j];
      }
      int ans = Integer.MAX_VALUE;
      for(int k = i; k < j; k++){
        ans = Math.min(ans, solveMemo(s, i, k, dp) + solveMemo(s, k + 1, j, dp));
      }
      
      return dp[i][j] = s.charAt(i) == s.charAt(j) ? ans - 1 : ans;
    }
}