class Solution{
    
    static int matrixMultiplication(int n, int arr[])
    {
         int[][] t=new int[102][102];
        for(int p=0;p< 102;p++)
{
          Arrays.fill(t[p],-1);
}
        
        return solve(arr,1,n-1,t);
    }
    static int  solve(int[] arr, int i,int j,int[][] t)
    {
        if(i>=j) return 0;
            if(t[i][j]!=-1) return t[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++)
        {   
            int temp=solve(arr,i,k,t) + solve(arr,k+1,j,t) + arr[i-1]*arr[j]*arr[k];
            min=Math.min(min,temp);
        }
        return t[i][j]=min;
    }
}