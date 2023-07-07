class Solution {
        
    public String shortestCommonSupersequence(String text1, String text2) {
       int n = text1.length(),m = text2.length();
        int[][] t = new int[n+1][m+1];
        for(int i= 0; i< n+1;i++){   //initialized
            for(int j = 0;j < m+1;j++){
                if(i == 0||j == 0) t[i][j] = 0;
            }
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    t[i][j] = t[i-1][j-1]+1;
                }
                else{
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        //t matrix is storing the length of lcs as a collection of subproblems 
        StringBuilder sb=new StringBuilder();
        // Appending the characters that are part of lcs.
        while(m>0 && n>0)
        {
            if(text1.charAt(n-1) == text2.charAt(m-1)){
                sb.append(text1.charAt(n-1));
                m--;
                n--;
            }
            else {
                if (t[n-1][m] >t[n][m-1]){
                    sb.append(text1.charAt(n-1));
                    n--;
                }
                else{
                    sb.append(text2.charAt(m-1));
                    m--;
                }
            }
        }
        //appending the remaining elements from both the strings.
        while(n>0)
        {
            sb.append(text1.charAt(n-1));
            n--;
        }
        while(m>0)
        {
            sb.append(text2.charAt(m-1));
            m--;
        }
        return sb.reverse().toString();
        
    }
    }