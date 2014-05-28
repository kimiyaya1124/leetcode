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
        
        TreeLinkNode lastHead = root;
        TreeLinkNode curHead = null;
        TreeLinkNode p = null;
        TreeLinkNode q = null;
        while(lastHead!=null){
            p = lastHead;
            while(p!=null){
                if(p.left!=null){
                    if(curHead==null){
                        curHead = p.left;
                        q = curHead;
                    }
                    else{
                        q.next = p.left;
                        q = q.next;
                    }
                }
                if(p.right!=null){
                    if(curHead==null){
                        curHead = p.right;
                        q = curHead;
                    }
                    else{
                        q.next = p.right;
                        q = q.next;
                    }
                }
                p = p.next;
            }
            lastHead = curHead;
            curHead = null;
        }
    }
}
