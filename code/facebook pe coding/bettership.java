public int[] bettership(int[][] grid)
{
    int i=0,j=0;
    while (i<grid.length())
    {
        while (j<grid[i].length)
        {
         if (findship(grid[i][j]))
         return new int []{i,j}; 
         else
          j+=2;
        }
        i++;
    }
}