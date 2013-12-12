public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> postarr = new ArrayList<Integer>();
        Stack<TreeNode> posttree = new Stack<TreeNode>();
        Stack<Integer> postarr2 = new Stack<Integer>();
        
        if(root==null)
            return postarr;
        
        posttree.push(root);
        TreeNode l;
        
        while(!posttree.empty()){
            l = posttree.pop();
            postarr2.push(l.val);
            if(l.left!=null)
                posttree.push(l.left);
            if(l.right!=null)
                posttree.push(l.right);
        }
        
        Integer t;
        while(!postarr2.empty()){
            t = postarr2.pop();
            postarr.add(t);
        }
        return postarr;
    }
}
