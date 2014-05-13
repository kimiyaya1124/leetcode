/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        
        Stack<TreeLinkNode> pretree = new Stack<TreeLinkNode>();
        
        TreeLinkNode troot = root;
        
        pretree.push(troot);
        while(!pretree.empty()){
            troot = pretree.pop();
            if(troot.left!=null){
                troot.left.next=troot.right;
                pretree.push(troot.left);
                pretree.push(troot.right);
                
                if(troot.next!=null)
                    troot.right.next=troot.next.left;
            }
        }
    }
}
