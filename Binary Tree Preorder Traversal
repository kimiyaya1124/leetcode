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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        TreeNode l = root;
        ArrayList<Integer> prearr = new ArrayList<Integer>();
        Stack<TreeNode> pretree= new Stack<TreeNode>();
        
        if(root == null)
            return prearr;
            
        if((l.left==null) && (l.right==null)){
            prearr.add(root.val);
            return prearr;
        }
        
        pretree.add(l);
            
        while(!pretree.empty()){
            l = pretree.pop();
            prearr.add(l.val);
            if(l.right!=null){
                pretree.push(l.right);
            }
            if(l.left!=null)
                pretree.push(l.left);
        }
        return prearr;
    }
}
