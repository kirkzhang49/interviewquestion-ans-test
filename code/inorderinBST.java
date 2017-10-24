public class Solution
{
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p)
    {
        if (root == null) //base case if null stop
         return null;
         if (root.val <= p.val) //if p value larger than go right
         {
         return inorderSuccessor(root.right,p);//recusion 
         }
         else
         {
             TreeNode left = inorderSuccessor(root.left,p);
             //if p val less than root.val go left
             return (left!=null) ? left:root;
             //接班人 found either return left or its root
         }
    }
}
/*
             A
          /     \
         B       C 
        / \     /  \
       D   E   F    G
          / \
         H   I
         
Inorder : DBHEIAFCG  (most left,parent,parent's right's most left,most left's parent,parent's right back track to parent)
Preorder: ABDEHICFG (root to left back track to parent then to right,back to previous parent to right recusively)
Postorder:DHIEBFGCA (from child to parent until root)
         
         
         
       
       
         
         