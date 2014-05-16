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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
            
        TreeNode t1 = root.left, t2 = root.right;       
        
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        
        while((t1!=null) || (t2!=null) || (!s1.empty() && !s2.empty())){
            boolean isnull = (t1==null) ^ (t2==null);
            if(isnull)
                return false;
            if((t1!=null) && (t2!=null)){
                if(t1.val!=t2.val)
                    return false;
                s1.push(t1);
                s2.push(t2);
                t1 = t1.left;
                t2 = t2.right;
            }
            else{
                t1 = s1.pop();
                t2 = s2.pop();
                t1 = t1.right;
                t2 = t2.left;
            }
        }
        
        return s1.empty() && s2.empty();
    }
}
