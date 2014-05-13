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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> inarr = new ArrayList<Integer>();
        Stack<TreeNode> intree = new Stack<TreeNode>();
            
        TreeNode troot = root;
        while( (troot!=null) || !intree.empty() )
        {
            if(troot!=null){
                intree.push(troot);
                troot = troot.left;
            }
            else{
                troot = intree.pop();
                inarr.add(troot.val);
                troot = troot.right;
            }
        }
        
        return inarr;
    }
}
