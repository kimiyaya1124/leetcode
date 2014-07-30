/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class ResPath{
    int singlePath;
    int maxPath;
    ResPath(int s, int l){
        singlePath = s;
        maxPath = l;
    }
}
public class Solution {
    public int maxPathSum(TreeNode root) {
        ResPath res = getMaxPath(root);
        return res.maxPath;
    }
    
    public ResPath getMaxPath(TreeNode root){
        ResPath res = new ResPath(0,Integer.MIN_VALUE);
        if(root==null){
            return res;
        }
        
        ResPath leftres = getMaxPath(root.left);
        ResPath rightres = getMaxPath(root.right);
        
        int sp = Math.max(leftres.singlePath,rightres.singlePath)+root.val;
        res.singlePath = Math.max(sp,0);
        int mp = Math.max(leftres.maxPath,rightres.maxPath);
        mp = Math.max(mp,leftres.singlePath+rightres.singlePath+root.val);
        res.maxPath = mp;
        return res;
    }
}
