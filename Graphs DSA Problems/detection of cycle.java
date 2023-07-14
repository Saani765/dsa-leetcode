import java.util.*;
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
         int[] visited = new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(checkCycle(i,-1,adj,visited)) return true;
            }
        }
        return false;
    }
    public boolean checkCycle(int cur,int parent,ArrayList<ArrayList<Integer>> adj,int[] visited){
        visited[cur]=1;
        
        for(int i=0;i<adj.get(cur).size();i++){
            int e=adj.get(cur).get(i);
            if(visited[e]==0){
                if(checkCycle(e,cur,adj,visited)) return true;
            }
            else if(e!=parent) return true;
        }
        return false;
    }
}