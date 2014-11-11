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
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if(root == null){
            return res;
        }
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode p = root;
        while(p != null || !st.empty()){
            if(p == null){
                TreeNode tr = st.pop();
                p = tr.right;
            }
            else{
                res.add(p.val);
                st.push(p);
                p = p.left;
            }
        }
        return res;
    }
}
