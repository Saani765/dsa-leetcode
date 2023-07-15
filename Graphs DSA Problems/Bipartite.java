import java.util.*;
class Solution {
    public boolean isBipartite(int[][] graph) {
        int v=graph.length;
        int[] vis=new int [v];
        for(int i=0;i<v;i++)
        {
            if(v!=0 && vis[i]==0)
            {
                vis[i]=1;
                Queue<Integer> q=new LinkedList<>();
                q.offer(i);
                while(!q.isEmpty())
                {
                    int cur=q.poll();
                    for(int it: graph[cur])
                    {
                        if(vis[it]==0)
                        {
                            vis[it]=(vis[cur]==1)? 2:1;
                            q.offer(it);
                        }
                        else 
                        {
                            if(vis[it]==vis[cur]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}