class Solution {
    private int n,m;
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int count=0;
        if (n==0) return count;
        m=grid[0].length;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (grid[i][j]=='1')
                {
                    dfs(grid,i,j);
                    count ++;
                }
            }
        }
        return count;
    }
    public void dfs(char[][]grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0') return;
        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
    }
}

https://discuss.leetcode.com/topic/29613/easiest-java-solution-with-explanations/2