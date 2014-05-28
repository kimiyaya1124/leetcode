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
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        return getSum(root,0);
    }
    
    public int getSum(TreeNode root,int sum){
        if((root.left==null) && (root.right==null)){
            return root.val+sum*10;
        }
        else{
            int leftval=0,rightval=0;
            if(root.left!=null){
                leftval = getSum(root.left,sum*10+root.val);
            }
            if(root.right!=null){
                rightval = getSum(root.right,sum*10+root.val);
            }
            return leftval+rightval;
        }
    }
}
