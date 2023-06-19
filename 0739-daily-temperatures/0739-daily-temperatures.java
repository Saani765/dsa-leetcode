class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ngr=  NGR(temperatures);
        int[] ans= new int[ngr.length];
        for(int i=0;i<ngr.length;i++)
        {
            if(ngr[i]==ngr.length) ngr[i]=0;
            else ngr[i]=ngr[i]-i;

        }
        return ngr;
        
    }

     private int[] NGR(int[] a)
    {
        Stack<Pair<Integer,Integer>> S =new Stack<>();
        ArrayList<Integer> ans= new ArrayList<>();
        int idx= a.length;
        for(int i=a.length-1;i>=0;i--)
        {
            if(S.empty()) ans.add(idx);
            else if(!S.empty() && S.peek().getKey()>a[i]) ans.add(S.peek().getValue());
            else if(!S.empty() && S.peek().getKey()<=a[i])
            {
                while(S.size()>0 && S.peek().getKey()<=a[i] ) {S.pop();}
                if(S.empty()) ans.add(idx);
                else ans.add(S.peek().getValue());
            }
            Pair<Integer, Integer> pair = new Pair<>(a[i], i);
            S.push(pair);
           
        } 
         Collections.reverse(ans);
        int[] ansf = ans.stream().mapToInt(Integer::intValue).toArray();
        return ansf;

    }
}