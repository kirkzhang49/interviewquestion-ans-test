public class Solution {
    public int shortestDistance(int[][] grid) {
        int min = Integer.MAX_VALUE;
        int M = grid.length;
        if (M!=0) N =grid[0].length;
        else N=0;
        int [] direct = {-1,0,1,0,-1};
        int [][] marked = new int [M][N];
        int cnt=0;
        Queue<int []> q = new LinkedList<>();
        for (int i =0;i<M;i++)
        {
            for (int j=0;j<N;j++)
            {
                if (grid[i][j]==1)
                {
                    q.offer(new int []{i,j});// current building position
                    bfs(q,grid,marked,direct,i,j,cnt++);
                }
            }
        }
        for (int i =0;i<M;i++)
        {
         for (int j =0;j<N;j++)
         {
             if (marked[i][j]==cnt)
             {
                 min = Math.min(min,-grid[i][j]);
             }
         }
        }
        return min ==Integer.MAX_VALUE ? -1 :min;
            }
    public void bfs (Queue<int []> q , int [][] grid , int [][] marked , int [] direct , int r, int c , int cnt)
    {
        int dist = 0;
        while (!q.isEmpty())
        {
         int size = q.size();
         dist ++;
         for (int i =0; i<size;i++)
         {
             int [] poll = q.poll();
             r = poll[0];
             c = poll[1];
            for (int j =0;j<4;j++)
            {
                int nextR = r + direct[j];
                int nextC = r + direct[j+1];
        if (nextR>=0 && nextR<grid.length&&nextC>=0&&nextC<grid[0].length&&grid[nextR][nextC]<=0&&marked[nextR][nextC]==cnt)
        {
            marked[nextR][nextC]++;
            q.offer(new int [] {nextR,nextC});
            grid[nextR][nextC] -= dist;
        }
            }
         }
        }
    }
}