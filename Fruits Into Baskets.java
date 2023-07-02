import java.util.HashMap;

class Solution {
    public int totalFruit(int[] fruits) {
        int i=0;
        int j=0;
        int longest=Integer.MIN_VALUE;
        HashMap<Integer,Integer> hm=new HashMap<>();
        while(j<fruits.length)
        {
            hm.put(fruits[j], hm.getOrDefault(fruits[j],0)+1);
            if(hm.size()<2) 
            {   longest=hm.get(fruits[j]);
                j++; }
            else if(hm.size()==2)
            {
                longest=Math.max(longest,j-i+1);
                j++;
            }
            else if(hm.size()>2)
            {
                int fruit=fruits[i];
                hm.put(fruit,hm.get(fruit)-1);
                if(hm.get(fruit)==0) hm.remove(fruit);
                i++;
                j++;
            }
        }
        return longest;

    }
}
