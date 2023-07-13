class Solution {
    public int orangesRotting(int[][] grid) {
        int time=2;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                dfs(grid,i,j,time);
            }
        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                return -1;
                time=Math.max(time,grid[i][j]);
            }
            
        }
        return (time-2);
    }
    
    private void dfs(int[][] grid,int i,int j,int time)
    {
         int m = grid.length;
        int n = grid[0].length;
        if (j < 0 || i < 0 || i >= m || j >= n || grid[i][j] == 0 || (grid[i][j] > 1 && grid[i][j] < time)) {
            return;
        } 
        grid[i][j] = time;  
        dfs(grid,i+1,j,time+1);
        dfs(grid,i-1,j,time+1);
        dfs(grid,i,j+1,time+1);
        dfs(grid,i,j-1,time+1);
        
    }
}