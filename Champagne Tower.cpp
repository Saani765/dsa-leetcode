class Solution {
public:
    double champagneTower(int poured, int query_row, int query_glass) {
        
        double dp[101][101]={0.0};
        
        //initial poured all champangne  in first cup 
        dp[0][0]=poured;
        
        for(int i=0;i<100;i++){
            
            
            for(int j=0;j<=i;j++){
                
                
                if(dp[i][j]>=1){
                    
                    dp[i+1][j]+=(dp[i][j]-1)/2.0; //poured half in left side
                    dp[i+1][j+1]+=(dp[i][j]-1)/2.0;//poured half in right cups
                    
                    dp[i][j]=1; //make the cup 1
                }
            }
        }
        return dp[query_row][query_glass];
    }
};
