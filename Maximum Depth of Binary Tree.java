public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        
        if( (root.left==null) && (root.right==null) )
            return 1;
            
        int lmax = maxDepth(root.left);
        int rmax = maxDepth(root.right);
        
        int max = lmax > rmax ? lmax+1 : rmax+1;
        return max;
    }
}
