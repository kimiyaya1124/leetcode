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
    public void flatten(TreeNode root) {
        if(root==null)
            return;
        
        TreeNode leftr = root.left;
        TreeNode rightr = root.right;
        root.right = leftr;
        root.left = null;
        TreeNode p = root;
        while(p.right!=null)
            p = p.right;
        p.right = rightr;
        flatten(root.right);
    }
    
}
