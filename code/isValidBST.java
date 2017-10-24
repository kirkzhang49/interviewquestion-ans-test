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
   private boolean help(TreeNode p, Integer low, Integer high) {
    if (p == null) return true;
    return (low == null || p.val > low) && (high == null || p.val < high) && help(p.left, low, p.val) && help(p.right, p.val, high);
}//if low not equal null val need to be larget than low also for high val need to be less, help (go left, high become val), go 
//right low become val recusively until it done

public boolean isValidBST(TreeNode root) {
    return help(root, null, null);
}
}