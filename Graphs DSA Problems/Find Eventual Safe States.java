import java.util.*;
class Solution {
    private boolean dfs(int[] vis,int[] pathvis,int[] check, int[][] graph, int node)
    {
        vis[node]=1;
        pathvis[node]=1;
        check[node]=0;
        for( int it: graph[node])
        {
            if(vis[it]==0) 
            {
                if(dfs(vis,pathvis,check,graph,it)) return true;
            }
            else if(pathvis[it]==1) return true;
        }
        check[node]=1;
        pathvis[node]=0;
        return false;
    }



    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v=graph.length;
        ArrayList<Integer> ans=new ArrayList<>();
       
        int[] vis= new int [graph.length];
        int[] pathvis= new int [graph.length];
        int[] check =new int[graph.length];
        for(int i=0;i<v;i++)
        {
            if(vis[i]==0) dfs(vis,pathvis,check,graph,i);
        }
        for(int i=0;i<v;i++)
        {
            if(check[i]==1) ans.add(i);
        }
        return ans;

    }
}