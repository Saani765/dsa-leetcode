import java.util.*;
class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<>());
        
        for(int[] pre:prerequisites)
            graph.get(pre[1]).add(pre[0]);
        
        boolean[] checked = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<numCourses;i++){
            boolean[] path = new boolean[numCourses];
            if(isCyclic(i,graph,stack,path,checked)==true)
                return new int[0];
        }
        int[] res = new int[numCourses];
        for(int i=0;i<numCourses;i++)
            res[i] = stack.pop();
        return res;
    }
    
    boolean isCyclic(int node,List<List<Integer>> graph,Stack<Integer> stack,boolean[] path,boolean[] checked){
        if(checked[node]==true)
            return false;
        if(path[node]==true)
            return true;
        path[node] = true;
        for(int adj:graph.get(node)){
            if(isCyclic(adj,graph,stack,path,checked)==true)
                return true;
        }
        stack.push(node);
        path[node] = false;
        checked[node] = true;
        return false;
    }
}