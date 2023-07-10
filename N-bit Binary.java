import java.util.ArrayList;

class Solution {
    ArrayList<String> res;
    ArrayList<String> NBitBinary(int N) {
        res = new ArrayList<String>();
        int count1 = 0, count0 = 0;
        solve(count1, count0, N, "");
        
        return res;
    }
    
    void solve(int count1, int count0, int N, String output){
        // base condition
        if(N==0){ // when we reach N=0, thn ouput would be one of the answers
            res.add(output);
            return;
        }
        
        // 1 can be chosen at any moment, provided N>0
        if(N>0){
            String output1 = new String(output);
            output1 += "1";
            solve(count1+1, count0, N-1, output1);
        }
        // if count1 > count0, then choosing 0 here is safe
        if(count1 > count0){
            String output2 = new String(output);
            output2 += "0";
            solve(count1, count0+1, N-1, output2);
        }
        
        
    }
}