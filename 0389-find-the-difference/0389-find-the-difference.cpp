class Solution {
public:
    char findTheDifference(string s, string t) {
        if(s.length()==0) return t[0];
        unordered_map<char,int> f;
        unordered_map<char,int> freq;
        char ans=' ';
        for(char c: s)
        {
            f[c]++;
        }
        for(char c: t)
        {
            freq[c]++;
            if(freq[c]>f[c]) {
                ans=c;
                break;
            } }
            
        return ans;
        
        
    }
};