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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length <= 0)
            return null;
        TreeNode root = buildTree2(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
        return root;
    }
    
    public TreeNode buildTree2(int[] inorder,int instart,int inend, int[] postorder,int poststart, int postend){
        if(instart>inend)
            return null;
        if(poststart>postend)
            return null;
        TreeNode root = new TreeNode(postorder[postend]);
        int split = 0;
        for(int i = instart; i <= inend; i++){
            if(inorder[i]==root.val){
                split = i;
                break;
            }
        }
        root.left = buildTree2(inorder,instart,split-1,postorder,poststart,poststart+split-instart-1);
        root.right = buildTree2(inorder,split+1,inend,postorder,poststart+split-instart,postend-1);
        return root;
    }
}
