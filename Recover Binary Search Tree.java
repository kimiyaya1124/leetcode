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
    TreeNode p,q,pre;
    public void recoverTree(TreeNode root) {
        if(root==null)
            return;
        getError(root);
        swap(p,q);
    }
    
    public void swap(TreeNode p, TreeNode q){
        int tmp = q.val;
        q.val = p.val;
        p.val = tmp;
    }
    
    public void getError(TreeNode root){
        if(root==null)
            return;
        getError(root.left);
        if((pre!=null) && (root.val<pre.val)){
            if(p == null){
                p = pre;
                q = root;
            }
            else
                q = root;
        }
        pre = root;
        getError(root.right);
    }
}
