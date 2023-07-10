import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        int open=n;
        int close=n;
        String op="";
        solve(open,close,op,ans);
        return ans;
    }
    void solve(int open,int close,String op,List<String> ans )
    {
        if(open==0&& close==0)
        {ans.add(op);
        return;}
        if(open!=0)
        {
            String op1=op+"(";
            
            solve(open-1,close,op1,ans);
            

        }
        if(close>open)
        {
            String op2=op+")";
            
            solve(open,close-1,op2,ans);
            

        }
            return;
    }
}