/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class NodeInfo{
    int height;
    boolean isbalanced;
}
public class Solution {
    public boolean isBalanced(TreeNode root) {
        NodeInfo ni = isBalancedWithHeight(root);
        return ni.isbalanced;
    }
    
    public NodeInfo isBalancedWithHeight(TreeNode root){
        NodeInfo ni = new NodeInfo();
        if(root==null){
            ni.isbalanced = true;
            ni.height = 0;
        }
        else{
            NodeInfo nleft = isBalancedWithHeight(root.left);
            NodeInfo nright = isBalancedWithHeight(root.right);
            if(Math.abs(nleft.height-nright.height)<=1)
                ni.isbalanced = nleft.isbalanced && nright.isbalanced;
            else
                ni.isbalanced = false;
            ni.height = 1 + Math.max(nleft.height,nright.height);
        }
        return ni;
            
    }
}
