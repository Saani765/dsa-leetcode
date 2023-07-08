
//Recursive Solution 
// class Solution {
//     public int minCut(String s) {
//         if(s.length()==0) return 0;
//         return solve(s,0,s.length()-1);
//     }
//     private boolean isPalindrome(String s ,int i,int j)
//     {
        
//         while(i<j)
//         {
//             if(s.charAt(i)!=s.charAt(j)) return false;
//             i++;
//             j--;
//         }
//         return true;
//     }
//     private int solve(String s ,int i,int j)
//     {
//         if(i>=j) return 0;
//         if(isPalindrome(s,i,j)) return 0;
//         int min=Integer.MAX_VALUE;
//         for(int k=i;k<=j-1;k++)
//         {
//             int temp=solve(s,i,k) + solve(s,k+1,j) +1;
//             min=Math.min(min,temp);
//         }
//         return min;
//     }
// }
//Gave TLE on big cases


//Memoized Solution
// class Solution {
//     public int minCut(String s) {
//         int[][] t=new int[2002][2002];
//         for(int i=0;i<2002;i++)
//         {
//             Arrays.fill(t[i],-1);
//         }
//         if(s.length()==0) return 0;
//         return solve(s,0,s.length()-1,t);
//     }
//     private boolean isPalindrome(String s ,int i,int j)
//     {
        
//         while(i<j)
//         {
//             if(s.charAt(i)!=s.charAt(j)) return false;
//             i++;
//             j--;
//         }
//         return true;
//     }
//     private int solve(String s ,int i,int j,int[][] t)
//     {
//         if(i>=j) return 0;
//         if(isPalindrome(s,i,j)) return 0;
//         if(t[i][j]!=-1) return t[i][j];
//         int min=Integer.MAX_VALUE;
//         for(int k=i;k<=j-1;k++)
//         {
//             int temp=solve(s,i,k,t) + solve(s,k+1,j,t) +1;
//             min=Math.min(min,temp);
//         }
//         return t[i][j]=min;
//     }
// }
//Gave TLE on bigger cases


//Optimized Memoization Solution
//Function to check if the string is Palindrome
class Solution {
    private static void isPalindrome(String s,int[][] isPalindrome){
        for(int i=0;i<s.length();i++){
            isPalindrome[i][i] = 0;
            for(int j=i-1,k=i+1;j>=0&&k<s.length();j--,k++){
                if(s.charAt(j)==s.charAt(k)) isPalindrome[j][k] = 0;
                else break;
            }
            for(int j=i,k=i+1;j>=0&&k<s.length();j--,k++){
                if(s.charAt(j)==s.charAt(k)) isPalindrome[j][k] = 0;
                else break;
            }
        }
    }

    private static int fun(String s, int[][] isPalindrome){
        int len = s.length();
        int[] dp = new int[len+1];
        dp[len] = 0;
        for(int cut=len-1;cut>=0;cut--){
            int minCuts = Integer.MAX_VALUE;
            for(int partition=cut;partition<len;partition++){
                if(isPalindrome[cut][partition]==0){
                    int cuts = 1 + dp[partition+1];
                    minCuts = Math.min(minCuts,cuts);
                }
            }
            dp[cut] = minCuts;
        }
        return dp[0]-1;
    }

    public int minCut(String s){
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        int[][] isPalindrome = new int[s.length()][s.length()];
        Arrays.stream(isPalindrome).forEach(a -> Arrays.fill(a,-1));
        isPalindrome(s,isPalindrome);
        return fun(s,isPalindrome);
    }
}
// Optimized Tabulation Code 
// Time Complexity : O(n * n)
// Space Complexity : O(n + n * n)

// Over all optimization in the code 
// In our previous approaches, we were calculating the isPalindrome for every subString again and // again which have many overlapping sub problems...
// We optimised out code by memoizing the data about isPalindrome in an dp data structure
// isPalindrome[i][j], where isPalindrome[i][j] = 0, s[i...j] is palindrome and 
// isPalindrome[i][j]=-1, means s[i...j] is not a palindrome.