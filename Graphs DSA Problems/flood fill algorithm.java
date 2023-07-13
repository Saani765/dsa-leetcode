class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {
        int color=image[sr][sc];
        if(color!=newcolor)
        {
            dfs(image,sr,sc,newcolor,color);
        }
        return image;
    }
    private void dfs(int[][] image,int sr,int sc,int newcolor,int color)
    {
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[sr].length || image[sr][sc]!=color) return;
        image[sr][sc]=newcolor;
        dfs(image,sr+1,sc,newcolor,color);
        dfs(image,sr-1,sc,newcolor,color);
        dfs(image,sr,sc+1,newcolor,color);
        dfs(image,sr,sc-1,newcolor,color);
    }
}