import java.util.Arrays;

class Solution{
    static int palindromicPartition(String s)
    {
        // code here
        int[][] t=new int[2002][2002];
        for(int i=0;i<2002;i++)
        {
            Arrays.fill(t[i],-1);
        }
        if(s.length()==0) return 0;
        return solve(s,0,s.length()-1,t);
    }
    static boolean isPalindrome(String s ,int i,int j)
    {
        
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    static int solve(String s ,int i,int j,int[][] t)
    {
        if(i>=j) return 0;
        if(isPalindrome(s,i,j)) return 0;
        if(t[i][j]!=-1) return t[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++)
        {
            int temp=solve(s,i,k,t) + solve(s,k+1,j,t) +1;
            min=Math.min(min,temp);
        }
        return t[i][j]=min;
    }
}