class Solution 
{
    public void dfs(char m[][],int i,int j)
    {
        if(i<0 || j<0 || i>=m.length || j>=m[0].length)
        return;
        if(m[i][j]!='1')
        return;
        m[i][j]='9';
        dfs(m,i-1,j);
        dfs(m,i,j+1);
        dfs(m,i+1,j);
        dfs(m,i,j-1);
    }
    public int numIslands(char[][] grid) 
    {
        int i,j,counter=0;
        for(i=0;i<grid.length;i++)
        {
            for(j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    counter++;
                    dfs(grid,i,j);
                }
            }
        }
        return counter;
    }
}