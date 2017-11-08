class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root==null) return 0;
        return helper(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);//helper to go depth, pathSum from start again left right recusive found all path tree add to sum
    }
    private int helper(TreeNode root,int sum)
    {
        if (root==null) return 0;
        return (root.val==sum?1:0) +helper(root.left,sum-root.val)+helper(root.right,sum-root.val);//go depth if found the path +1 else 0
    }
}//number of sub path add to sum

class Solution {//recusively find all path add to sum
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root,new ArrayList<>(),result,sum);
        return result;
    }
    public void pathSum(TreeNode root,List<Integer> cur, List<List<Integer>> result,int sum){
        if (root==null) return;
        cur.add(new Integer(root.val));
        if (root.left==null&&root.right==null&&root.val==sum){result.add(new ArrayList<>(cur));}
        else {
            pathSum(root.left,cur,result,sum-root.val);
            pathSum(root.right,cur,result,sum-root.val);
        }
        cur.remove(cur.size()-1);
    }
}



class Solution {//check if path sum exist
    public boolean hasPathSum(TreeNode root, int sum) {
                if(root==null) return false;
                if (root.left==null&&root.right==null&&root.val==sum) return true;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
}





// 111 215 representation path sum
class Solution {
    int sum = 0;
    Map<Integer, Integer> tree = new HashMap<>();
    
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        for (int num : nums) {
            int key = num / 10;
            int value = num % 10;
            tree.put(key, value);
        }
        
        traverse(nums[0] / 10, 0);
        
        return sum;
    }
    
    private void traverse(int root, int preSum) {
        int level = root / 10;
        int pos = root % 10;
        int left = (level + 1) * 10 + pos * 2 - 1;
        int right = (level + 1) * 10 + pos * 2;
        
        int curSum = preSum + tree.get(root);
        
        if (!tree.containsKey(left) && !tree.containsKey(right)) {
            sum += curSum;
            return;
        }
        
        if (tree.containsKey(left)) traverse(left, curSum);
        if (tree.containsKey(right)) traverse(right, curSum);
    }
}