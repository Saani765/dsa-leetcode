class Solution {
    int rows,cols;
    public int numEnclaves(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        
        for(int i=0;i<rows;i++)
        {
            for(int j = 0;j<cols;j++)
            {
                if((i==0 || j==0 || i==rows-1 || j==cols-1) && (grid[i][j] == 1))
                    dfs1(grid,i,j);
            }
        }
        
        int max_count = 0;
        for(int i=0;i<rows;i++)
        {
            for(int j = 0;j<cols;j++)
            {
                if(grid[i][j] == 1)
                    max_count++;
            }
        }
        return max_count;
    }
    void dfs1(int[][] grid,int i,int j)
    {
        if(i<0||j<0||i>=rows||j>=cols||grid[i][j]==0)
            return ;
        grid[i][j] = 0;
        
        dfs1(grid,i+1,j);
        dfs1(grid,i-1,j);
        dfs1(grid,i,j+1);
        dfs1(grid,i,j-1);
    }
    
}