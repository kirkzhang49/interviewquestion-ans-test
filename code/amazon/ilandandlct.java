public TreeNode lowestCommonAncestor (TreeNode root, TreeNode p ,TreeNode q)
{
   if (root==null) return null;
   TreeNode left = lowestCommonAncestor(root.left,p,q);//go left to find lowestCommonAncestor
   TreeNode right = lowestCommonAncestor(root.right,p,q);//go right to find lowestCommonAncestor
   if (left !=null&&right!=null||root==p||root==q)
   {
     return root;
   }
   else if (right == null) return left;  //if nothing on right
   else return right;//else return left
}

public class Solution
{
    public int numIslands(char [][] grid)
    {
      int count =0;
      for (int i =0;i<grid.length;i++)
      {
         for (int j =0;j<grid[i].length;j++)
         {
           if (grid[i][j] == '1')//find one land
           {
             count ++;//increase land
             clearRestOfland(grid,i,j);
           }
         }
      }
      return count;
    }
    private void clearRestOfland(char [][] grid, int i ,int j )
    {
      if (i<0||j<0||i>=grid.length||j>-grid[i].length||grid[i][j]=='0') return ;
      grid[i][j] = '0'; //set all adj land to water
      clearRestOfland(grid,i+1,j);
      clearRestOfland(grid,i-1,j);
      clearRestOfland(grid,i,j+1);
      clearRestOfland(grid,i,j-1);
    }
}


