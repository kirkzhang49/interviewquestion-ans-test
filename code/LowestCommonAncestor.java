/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 public class Solution {
     public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q)
     {
         Map<TreeNode,TreeNode> parent = new HashMap<>();   
         Deque<TreeNode> stack = new ArrayDeque<>();//double side first in first out que
         parent.put(root,null);
         stack.push(root);
         while (!parent.containsKey(p)||!parent.containsKey(q))
         {
             TreeNode node =stack.pop();//first in last out(root is first) until both input has parent
             if (node.left != null)
             {
                 parent.put(node.left,node);//make node as parent of node.left
                 stack.push(node.left);//put node.left to stack top
             }
             if (node.right !=null)
             {
                 parent.put(node.right,node);//make node as parent of node.right
                 stack.push(node.right);//put node.right to stack top
             }
         }//store until map parent have all the parent of p and q 
         Set<TreeNode> ancentors = new HashSet<>();
         while (p!=null)
         {
             ancentors.add(p);//add all the p and parents of p as ancestors
             p = parent.get(p);// go to the parent of p
         }
         while (!ancentors.contains(q))//if ancestors not contains the q
         {
             q = parent.get(q);//go to parent of q until find in the set of parent of p
             //the lowestCommonAncestor is found
         }
         return q;
     }
 }

 public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,TreeNode q)
         {
             if (root ==null) return null;//default
             if (root ==p||root ==q) return root;//root is p or q and lca
             TreeNode left = lowestCommonAncestor(root.left,p,q);//try left
             TreeNode right =lowestCommonAncestor(root.right,p,q);//try right
             if (left!=null&&right!=null) //we found node from both side return current root
             return root;
             return (left !=null) ?left :right;//if left is the last node(no more left) return left else return right
 }
 }