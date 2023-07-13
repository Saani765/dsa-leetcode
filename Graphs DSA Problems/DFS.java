import java.util.*;
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis=new boolean[V];
        vis[0]=true;
        ArrayList<Integer> ans=new ArrayList<>();
        dfs(adj,ans,0,vis);
        return ans;
        
    }
     private static void dfs(ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans,int node,boolean[] vis)
     {
        vis[node]=true;
        ans.add(node);
        for(int it: adj.get(node))
        {
            if(vis[it]!=true)
            {
                dfs(adj,ans,it,vis);
            }
        }
     }
}