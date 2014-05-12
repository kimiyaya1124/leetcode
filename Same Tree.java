public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p==null) && (q==null))
            return true;
            
        if(p==null)
            return false;
        
        if(q==null)
            return false;
            
        if(p.val==q.val){
            boolean isSameleftTree = isSameTree(p.left,q.left);
            boolean isSamerightTree = isSameTree(p.right,q.right);
            return (isSameleftTree && isSamerightTree);
        }
        else return false;
    }
}
