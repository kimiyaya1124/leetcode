/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class treeInfo{
    int minval;
    int maxval;
    boolean isBST;
    treeInfo(){
        minval = Integer.MIN_VALUE;
        maxval = Integer.MAX_VALUE;
        isBST = false;
    }
}
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        
        treeInfo ti = getTreeInfo(root);
        return ti.isBST;
    }
    
    public treeInfo getTreeInfo(TreeNode root){
        if((root.left==null) && (root.right==null)){
            treeInfo ti = new treeInfo();
            ti.minval = root.val;
            ti.maxval = root.val;
            ti.isBST = true;
            return ti;
        }
        
        treeInfo resti = new treeInfo();
        int maxl, minr;
        if(root.left==null){
            treeInfo righti = getTreeInfo(root.right);
            if(!righti.isBST)
                return resti;
            resti.minval = Math.min(root.val,righti.minval);
            resti.maxval = Math.max(root.val,righti.maxval);
            maxl = Integer.MIN_VALUE;
            minr = righti.minval;
        }
        else{
            if(root.right==null){
                treeInfo lefti = getTreeInfo(root.left);
                if(!lefti.isBST)
                    return resti;
                resti.minval = Math.min(root.val,lefti.minval);
                resti.maxval = Math.max(root.val,lefti.maxval);
                maxl = lefti.maxval;
                minr = Integer.MAX_VALUE;
            }
            else{
                treeInfo lefti = getTreeInfo(root.left);
                treeInfo righti = getTreeInfo(root.right);
                if(!(lefti.isBST && righti.isBST))
                    return resti;
                resti.minval = Math.min(lefti.minval,righti.minval);
                resti.maxval = Math.max(lefti.maxval,righti.maxval);
                maxl = lefti.maxval;
                minr = righti.minval;
            }
        }
        if((maxl<root.val) && (minr > root.val))
            resti.isBST = true;
        else
            resti.isBST = false;
        return resti;
    }
}
