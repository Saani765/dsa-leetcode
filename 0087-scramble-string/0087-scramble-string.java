//RECURSIVE SOLUTION (NOT ACCEPTED TLE)
// class Solution {
//     public boolean isScramble(String s1, String s2) {
//         if(s1.equals(s2)) return true;
//         if(s1.length()<=1) return false;
//         int n=s1.length();
//         boolean flag=false;
//         for(int i=1;i<=n-1;i++)
//         { 

//             if(isScramble(s1.substring(0,i),s2.substring(n-i,n)) && (isScramble(s1.substring(i,n),s2.substring(0,n-i))) || isScramble(s1.substring(0,i),s2.substring(0,i)) && (isScramble(s1.substring(i,n),s2.substring(i,n))))
//             {
//                 flag=true;
//                 break;
//             }

//         }
//         return flag; 

//     }
// }


// //OPTIMIZED SOLUTION (MEMOIZATION)
// class Solution {
//     HashMap<String,Boolean> memo;
//     public boolean isScramble(String s1, String s2) {
//         if(s1.equals(s2)) return true;
//         if(s1.length()<=1) return false;
//         memo = new HashMap<String,Boolean>();
//         String key=s1+" "+s2;
//         if(memo.containsKey(key)){
//             return memo.get(key);
//         }
//         int n=s1.length();
//         boolean flag=false;
//         for(int i=1;i<=n-1;i++)
//         { 

//             if(isScramble(s1.substring(0,i),s2.substring(n-i,n)) && (isScramble(s1.substring(i,n),s2.substring(0,n-i))) || isScramble(s1.substring(0,i),s2.substring(0,i)) && (isScramble(s1.substring(i,n),s2.substring(i,n))))
//             {
//                 flag=true;
//                 break;
//             }

//         }
//         memo.put(key,flag);
//         return flag; 

//     }
// }

class Solution {
    public boolean isScramble(String s1, String s2) {
        int n1 = s1.length(),n2 = s2.length();
        if(n1 != n2){return false;}
        memo = new HashMap<String,Boolean>();
        boolean ans = helperDp(s1,s2);
        return ans;
    }
    HashMap<String,Boolean> memo;

    public boolean helperDp(String s1,String s2){
        if(s1.equals(s2)){return true;}
        if(s1.length()<=1 || s2.length()<=1){return false;}
        String key = s1+" "+s2;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        boolean flag = false;
        int n = s1.length();
        for(int i = 1;i<n;i++){
            boolean condition1 = helperDp(s1.substring(0,i),s2.substring(n-i,n)) && helperDp(s1.substring(i,n),s2.substring(0,n-i));
            if(condition1){flag = true;break;}
            boolean condition2 = helperDp(s1.substring(0,i),s2.substring(0, i)) && helperDp(s1.substring(i, n),s2.substring(i, n));
            if(condition2){flag = true;break;}
        }
        memo.put(key,flag);
        return flag;
    }
}