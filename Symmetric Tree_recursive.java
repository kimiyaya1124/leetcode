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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
            
        return isSymmetric2(root,root); 
    }
    
    public boolean isSymmetric2(TreeNode leftRoot,TreeNode rightRoot){
        boolean isnull = (leftRoot==null) && (rightRoot==null);
        boolean isnull2 = (leftRoot!=null) && (rightRoot!=null);
        
        if(isnull)
            return true;
        else
            if(!isnull2)
                return false;
        
        if(leftRoot.val!=rightRoot.val)
            return false;
        
        boolean isleftSym = isSymmetric2(leftRoot.left,rightRoot.right);
        if(!isleftSym)
            return false;
        boolean isrightSym = isSymmetric2(leftRoot.right,rightRoot.left);
        return isleftSym && isrightSym;
    }
}
