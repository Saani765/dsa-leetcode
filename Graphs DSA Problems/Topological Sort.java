import java.util.*;
class Solution
{   
    
    static void dfs(int node, int[] vis,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st)
    {
        vis[node]=1;
        for(int it: adj.get(node))
        {
            if(vis[it]==0) dfs(it,vis,adj,st);
        }
        st.push(node);
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int [] vis= new int [V];
        Stack<Integer> st=new Stack<>();
        int [] ans=new int [V];
        for(int i=0;i< V;i++)
        {
            if(vis[i]==0) dfs(i,vis,adj,st);
            
        }
        int i=0;
        while(!st.isEmpty())
        {
            ans[i++]=st.peek();
            st.pop();
        }
        return ans;
    }
}
