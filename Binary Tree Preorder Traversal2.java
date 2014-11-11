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
        st.push(root);
        while(!st.empty()){
            TreeNode tr = st.pop();
            res.add(tr.val);
            if(tr.right != null){
                st.push(tr.right);
            }
            if(tr.left != null){
                st.push(tr.left);
            }
        }
        
        return res;
    }
}
