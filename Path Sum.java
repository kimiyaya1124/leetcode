/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        if(root==null)
            return false;
        if( (root.left==null) && (root.right==null) && (root.val==sum) )
            return true;
        
        boolean isleft = false,isright=false;
        if(root.left!=null)
            isleft = hasPathSum(root.left,sum-root.val);
        if(isleft)
            return isleft;
        if(root.right!=null)
            isright = hasPathSum(root.right,sum-root.val);
        return isright;
    }
}
