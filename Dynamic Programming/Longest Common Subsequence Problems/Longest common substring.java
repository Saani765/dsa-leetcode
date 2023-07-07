class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        // code here
        int [][] t=new int [n+1][m+1];
        int len=0;
        for(int i=0;i<n+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                if(i==0 || j==0) t[i][j]=0;
            }
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(S1.charAt(i-1)==S2.charAt(j-1))
                {t[i][j]=1+t[i-1][j-1];
                    len=Math.max(len,t[i][j]);
                }
                
            }
        }
        return len;
        
    }
}