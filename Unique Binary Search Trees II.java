/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if(n <= 0){
            res.add(null);
            return res;
        }
        res = gt(1,n);
        return res;
    }
    
    public ArrayList<TreeNode> gt(int left, int right){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if(left>right){
            res.add(null);
            return res;
        }
        int i = left;
        for(i = left; i<=right;i++){
            ArrayList<TreeNode> lt = gt(left,i-1);
            ArrayList<TreeNode> rt = gt(i+1,right);
            for(int j = 0; j < lt.size();j++){
                for(int k = 0; k < rt.size();k++){
                    TreeNode root = new TreeNode(i);
                    root.left = lt.get(j);
                    root.right = rt.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
