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
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        if((root.left==null) && (root.right==null)){
            return 1;
        }
        int leftD=-1, rightD = -1;
        leftD = minDepth(root.left);
        rightD = minDepth(root.right);
        if(leftD==0)
            return rightD+1;
        if(rightD==0)
            return leftD+1;
        return Math.min(leftD,rightD)+1;
    }
}
